package lab01.sample.challenge;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeoutException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import lab01.sample.common.Message;

public class RabbitMQCommunicator {

	public void sendMessage(String input, String exchangeName, String routingKey)
			throws IOException, KeyManagementException, NoSuchAlgorithmException, URISyntaxException, TimeoutException {

		ConnectionFactory factory = new ConnectionFactory();
		factory.setUri("amqp://userName:password@hostName:portNumber/virtualHost");

		try (final Connection conn = factory.newConnection(); final Channel channel = conn.createChannel()) {

			// fancy message transformation business logic
			Message message = new Message();
			message.setSomeText("The user said: " + input);
			message.setSomeValue(input.length() + 42);
			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date());
			cal.add(Calendar.DATE, -30);
			Date dateBefore30Days = cal.getTime();
			message.setSomeDate(dateBefore30Days);

			Gson gson = (new GsonBuilder()).setDateFormat("yyyy-MM-dd").create();
			byte[] messageBodyBytes = gson.toJson(message).getBytes();

			channel.basicPublish(exchangeName, routingKey, null, messageBodyBytes);

		}

	}

}
