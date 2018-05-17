package lab01.excercise.solution.trainer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.annotation.Nonnull;

import lab01.excercise.common.InsurancePolicy;
import lab01.excercise.common.Vehicle;
import lab01.excercise.common.VehicleType;

public class PolicyPersistence {
	
	public void savePolicy(@Nonnull InsurancePolicy policy, @Nonnull String file) {
		
		Objects.requireNonNull(policy);
		Objects.requireNonNull(file);
		
		List<String> lines = new ArrayList<>();
		lines.add(policy.getPolicyNr());
		lines.add(Long.toString(policy.getPremium())); 

		lines.addAll(
				policy.riskStream().map(r -> {
					return Long.toString(r.getPremium())+","+r.getVehicle().getRegistrationId()+","+r.getVehicle().getType().toString();
				}).collect(Collectors.toList()));

		try {
			Files.write(Paths.get(file), lines);
		} catch (IOException ioe) {
			throw new RuntimeException(ioe);
		}
		
	}

	public static void main(String[] args) {
		
		PolicyPersistence persistence = new PolicyPersistence();
		PolicyLogic logic = new PolicyLogic();
		
		InsurancePolicy policy = logic.insureVehicles(
				new Vehicle("WB-123AB",VehicleType.MOTORCYCLE,98),
				new Vehicle("WB-987YZ",VehicleType.CAR, 85));
		
		persistence.savePolicy(policy,"/Temp/policy2.txt");
	}
	
}
