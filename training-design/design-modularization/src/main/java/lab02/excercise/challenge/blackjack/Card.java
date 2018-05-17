package lab02.excercise.challenge.blackjack;

public enum Card {
	
    C1(1), C2(2), C3(3), C4(4), C5(5), C6(6), C7(7), C8(8), C9(9), C10(10), 
    JACK(10), QUEEN(10), KING(10), ACE(11,1);

    private int[] numVal;

    Card(int... numVal) {
        this.numVal = numVal;
    }

    public int getNoOfValues() {
    	return numVal.length;
    }
    
    public boolean isJackQueenOrKing() {
    	return 
    			JACK.toString().equals(name()) || 
    			QUEEN.toString().equals(name()) || 
    			KING.toString().equals(name());
    }
    
    public int getNumVal(int index) {
        return numVal[index];
    }
    
}
