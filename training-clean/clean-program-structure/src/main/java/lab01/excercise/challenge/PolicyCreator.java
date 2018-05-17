package lab01.excercise.challenge;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import lab01.excercise.common.InsurancePolicy;
import lab01.excercise.common.Risk;
import lab01.excercise.common.Vehicle;
import lab01.excercise.common.VehicleType;

public class PolicyCreator {
	
	public InsurancePolicy createAndSavePolicy(Vehicle... vehicles) {
		
		InsurancePolicy policy = new InsurancePolicy();
		
		Arrays.stream(vehicles).forEach( vehicle -> {
			
			Risk newRisk = new Risk();
			newRisk.setVehicle(vehicle);
			
			// basic premium
			newRisk.setPremium(100);
			
			if (VehicleType.MOTORCYCLE.equals(vehicle.getType())) {
				
				if (vehicle.getHorsePower() > 120) {
					throw new IllegalArgumentException("Motorcycles above 120 horsepower cannot be insured");
				}
				if (vehicle.getHorsePower() > 20) {
					newRisk.setPremium(newRisk.getPremium()*2);
				}
				if (vehicle.getHorsePower() > 60) {
					newRisk.setPremium(newRisk.getPremium()*2);
				}
				
			} else if (VehicleType.CAR.equals(vehicle.getType())) {
				
				newRisk.setPremium(newRisk.getPremium()*4);
				if (vehicle.getHorsePower() > 100) {
					newRisk.setPremium(newRisk.getPremium()*2);
				}
				
			} else if (VehicleType.CAR.equals(vehicle.getType())) {

				// Flatrate
				newRisk.setPremium(newRisk.getPremium()*10);
			}
			
			policy.addRisks(newRisk);
			
		});
		
		policy.setPremium( policy.riskStream().map(r -> r.getPremium()).mapToLong(p -> p).sum() );
		
		policy.setPolicyNr( UUID.randomUUID().toString() );
		
		List<String> lines = new ArrayList<>();
		lines.addAll(Arrays.asList(policy.getPolicyNr(), Long.toString(policy.getPremium()))); 

		lines.addAll(
				policy.riskStream().map(r -> {
					return Long.toString(r.getPremium())+","+r.getVehicle().getRegistrationId()+","+r.getVehicle().getType().toString();
				}).collect(Collectors.toList()));

		try {
			Files.write(Paths.get("/Temp/policy.txt"), lines);
		} catch (IOException ioe) {
			throw new RuntimeException(ioe);
		}
		
		return policy;
	}
	
	public static void main(String[] args) {
		
		PolicyCreator creator = new PolicyCreator();
		
		creator.createAndSavePolicy(
				new Vehicle("WB-123AB",VehicleType.MOTORCYCLE,98),
				new Vehicle("WB-987YZ",VehicleType.CAR, 85));
		
	}

}
