
public class Pyramid {
		
	public static void main(String args[]) {
		String pyramid = getPyramid(1000, 11);
		System.out.println(pyramid);
	}

	private static String getPyramid(int topOfPyramidNum, int numLevels) {
		int lenTerminatingNumber = Integer.valueOf(topOfPyramidNum + numLevels).toString().length();
		int lenTerminatingLine = getFinalLineLength(topOfPyramidNum, numLevels);
		int spacesBeforeNumOnRight = (lenTerminatingLine / 2) - (lenTerminatingNumber / 2);
		int spacesBeforeNumOnLeft = 0;
		int currentNum = topOfPyramidNum;
		String pyramid = "";
		for(int rowNum = 0; rowNum < numLevels; rowNum++) {
			pyramid += getIndation(spacesBeforeNumOnRight);
			pyramid += currentNum;
			if(rowNum == 1) {
				spacesBeforeNumOnLeft = Integer.valueOf(currentNum).toString().length();
			}
			if(rowNum > 1) {
				spacesBeforeNumOnLeft += Integer.valueOf(currentNum).toString().length() * 2;
			}
			pyramid += rowNum > 0 ? getIndation(spacesBeforeNumOnLeft) : ""; 
			pyramid += rowNum > 0 ? currentNum : "";
			pyramid += "\n";
			currentNum++;
			spacesBeforeNumOnRight -= Integer.valueOf(currentNum).toString().length(); 
		}
		return pyramid;
	}

	private static String getIndation(int indentationThisLine) {
		String emptySpaces = "";
		for(int i = 0; i < indentationThisLine; i++) {
			emptySpaces += " ";
		}
		return emptySpaces;
	}

	private static int getFinalLineLength(int topOfPyramidNum, int numLevels) {
		int numSpaces = 0;
		for(int rowNumber = 0; rowNumber < numLevels; rowNumber++) {
			int spacesOccupiedByNumber = Integer.valueOf(topOfPyramidNum).toString().length();
			numSpaces += spacesOccupiedByNumber; // The right occurrence of the number
			numSpaces += rowNumber > 0 ? spacesOccupiedByNumber : 0; // The left occurrence of the number
			// Space between numbers on second row
			if(rowNumber == 1) {
				numSpaces += Integer.valueOf(topOfPyramidNum).toString().length();
			}
			// Space between numbers after second row
			if (rowNumber > 1) {
				numSpaces += (Integer.valueOf(topOfPyramidNum).toString().length() * 2);
			}
			topOfPyramidNum++;
		}
		return numSpaces;
	}
}
