package lab01.excercise.solution.trainer;

import lab01.excercise.solution.trainer.equipment.ViewingFacade;

public class Viewer {
	
	private final static String LIFE_OF_BRIAN_BLU_RAY = 				
			"All right, but apart from the sanitation, medicine, education, wine, public order, "+
			"irrigation, roads, the fresh water system and public health, what have the Romans ever done for us?";

	
	public static void main(String[] args) {
		
		ViewingFacade viewing = new ViewingFacade(System.out::println,System.err::println);
		
		// Let´s watch The Dark Knight on channel 3
		viewing.watchSatChannel(3);
		
		// Now let´s watch Life of Brian on BluRay
		viewing.watchBluRay(LIFE_OF_BRIAN_BLU_RAY);

		// enough for today
		viewing.stopWatching();
	}

}
