package lab01.excercise.solution.trainer;

import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.Nonnull;

import lab01.excercise.common.InsurancePolicy;
import lab01.excercise.common.Risk;
import lab01.excercise.common.Vehicle;

public class PolicyLogic {
	
	// In this class it was decided, that we do not use constants for many values,
	// as their meaning should become clear from the context of their usage.
	// This is especially about horse power limits and premium factors
	
	private static long BASIC_PREMIUM = 100L;
	
	public InsurancePolicy insureVehicles(Vehicle... vehicles) {
		
		InsurancePolicy policy = new InsurancePolicy();
		policy.setPolicyNr(generatePolicyNr());
		
		AtomicLong overallPremium = new AtomicLong(0L);
		
		Arrays.stream(vehicles).forEach( vehicle -> {
			Risk newRisk = createVehicleRisk(vehicle);
			overallPremium.addAndGet(newRisk.getPremium());
			policy.addRisks(newRisk);
		});
		
		policy.setPremium(overallPremium.get());
		
		return policy;
	}
	
	private long calculateMotorcyclePremium(int horsePower) {
		
		long result = BASIC_PREMIUM;
		
		if (horsePower > 120) {
			throw new IllegalArgumentException("Motorcycles above 120 horsepower cannot be insured");
		}
		if (horsePower > 20) {
			result = result * 2;
		}
		if (horsePower > 60) {
			result = result * 2;
		}
		
		return result;
	}
	
	private long calculateCarPremium(int horsePower) {
		
		long result = BASIC_PREMIUM * 4;
		if (horsePower > 100) {
			result = result * 2;
		}
		return result;
	}
	
	private long calculateTruckPremium(int horsePower) {
		return BASIC_PREMIUM * 10;
	}
	
	private Risk createVehicleRisk(@Nonnull Vehicle input) {
		
		Objects.requireNonNull(input);
		if (!input.invariant()) {
			throw new IllegalArgumentException("Invalid Vehicle");
		}
		
		Risk newRisk = new Risk();
		newRisk.setVehicle(input);
		
		switch (input.getType()) {
			case MOTORCYCLE: 
				newRisk.setPremium(calculateMotorcyclePremium(input.getHorsePower()));
				break;
			case CAR:
				newRisk.setPremium(calculateCarPremium(input.getHorsePower()));
				break;
			case TRUCK:
				newRisk.setPremium(calculateTruckPremium(input.getHorsePower()));
				break;
			default:
				throw new IllegalArgumentException(input.getType().toString());
		}
		
		return newRisk;
	}

	private String generatePolicyNr() {
		return UUID.randomUUID().toString();
	}
	
}
