package lab01.sample.solution;

import java.util.Calendar;
import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import lab01.sample.common.Message;

public class RabbitMQCommunicatorSLA {

	public Message warpTextInMessage(String input) {

		Message message = new Message();
		message.setSomeText("The user said: " + input);
		message.setSomeValue(input.length() + 42);
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, -30);
		Date dateBefore30Days = cal.getTime();
		message.setSomeDate(dateBefore30Days);

		return message;
	}

	public void sendMessage(Message input, String exchangeName, String routingKey) {

		try {
			ConnectionFactory factory = new ConnectionFactory();
			factory.setUri("amqp://userName:password@hostName:portNumber/virtualHost");

			try (Connection conn = factory.newConnection(); 
					Channel channel = conn.createChannel()) {

				channel.basicPublish(exchangeName, routingKey, null, convertMessageToJsonByteArray(input));
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	private byte[] convertMessageToJsonByteArray(Message message) {

		Gson gson = (new GsonBuilder()).setDateFormat("yyyy-MM-dd").create();
		return gson.toJson(message).getBytes();
	}

}
