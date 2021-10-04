package bigNumberApp;

import java.util.ArrayList;
import java.util.Arrays;



public class BigNumber {
	/**
	 * @author paetinnelson
	 * @version 1.0
	 */

	/**
	 * @param String num
	 *
	 */

	private String num;

	public BigNumber(String bigInt) {
		this.num = bigInt;
	}

	public String getStr() {
		return num;
	}

	public void setStr(String newNum) {
		this.num = newNum;
	}

	public String add(BigNumber num2) {
		String sum = "";
		Integer temp = 0;
		Integer count = 0;
		Integer dif;

		
		// here we are making both of the strings the same length by adding the necessary amount of 0s to the beginning of the shorter number
		if (num.length() > num2.getStr().length()) {
			dif = num.length() - num2.getStr().length();
			for (int j = 0; j < dif; j++) {
				num2.setStr("0" + num2.getStr());
			}
		} else if (num.length() < num2.getStr().length()) {
			dif = num2.getStr().length() - num.length();
			for (int k = 0; k < dif; k++) {
				num = "0" + num;
			}
		}
		
		
		

		String[] str = num.split(""); // splits the the first number into a string of individual numbers which we are going to put into an arraylist
		String[] stx = num2.getStr().split("");// splits the the second number into a string of individual numbers which we are going to put into an arraylist

		ArrayList<String> listOne = new ArrayList<String>(Arrays.asList(str)); // creating arraylist

		ArrayList<String> listTwo = new ArrayList<String>(Arrays.asList(stx)); // creating arraylist

		// we are now going to take the numbers in the two arraylists and add them
		// we start at the ones place so at the end of the arraylist and end at the beginning of the arraylist
		// this will make sure that the numbers are in correct order and will help us when we need to carry over numbers
		

		for (int i = listOne.size() - 1; i >= 0; i--) {
			temp = Integer.parseInt(listOne.get(i)) + Integer.parseInt(listTwo.get(i)); // this adds the numbers in the correct index to each other from the two arraylists

			if (count == 1) { // if we needed to carry over a number this does that
				temp += 1;
				count = 0;
			}

			if (temp < 10) { // if we don't need to carry over a number then just add our added number to our sum string
				sum = temp.toString() + sum;

			}
			if (temp >= 10) { // if the numbers we are adding exceed 10 (thus requiring us to carry over) then count = 1 which tells us that we need to add 1 to temp after next calculation
				count = 1;
				temp = temp - 10;
				sum = temp.toString() + sum;
			}
		}
		for (int y = 0; y <= sum.length(); y++) { // this makes sure that if there are unnecessary 0 at the beginning
			if (sum.charAt(0) == '0') {			// now 0098 + 2 = 100 and not 00100
				sum = sum.substring(1);
			}
		}
		return sum;// i decided to return the final sum as a string...just seemed easy at the time i guess
	}
}
