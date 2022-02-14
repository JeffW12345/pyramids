public class Pyramid {
		
	public static void main(String args[]) {
		String pyramid = getPyramid(997, 10);
		System.out.println(pyramid);
	}

	private static String getPyramid(int topOfPyramidNum, int numLevels) {
		int lenTerminatingNumber = String.valueOf(topOfPyramidNum + numLevels).length();
		int lenTerminatingLine = getFinalLineLength(topOfPyramidNum, numLevels);
		int spacesBeforeFirstNumOnRow = (lenTerminatingLine / 2) - (lenTerminatingNumber / 2);
		int spacesBeforeSecondNumOnRow = 0;
		int currentNum = topOfPyramidNum;
		int prevNum = 0;
		String pyramid = "";
		for(int rowNum = 0; rowNum < numLevels; rowNum++) {
			pyramid += getEmptySpaces(spacesBeforeFirstNumOnRow);
			pyramid += currentNum;
			if(rowNum == 1) {
				spacesBeforeSecondNumOnRow = String.valueOf(prevNum).length();
			}
			if(rowNum > 1) {
				spacesBeforeSecondNumOnRow += (String.valueOf(prevNum).length() * 2);
			}
			// If after starting row, add spaces before the second number
			if(rowNum > 0) {
				pyramid += getEmptySpaces(spacesBeforeSecondNumOnRow) + currentNum;
			}
			pyramid += "\n";
			prevNum = currentNum;
			currentNum++;
			spacesBeforeFirstNumOnRow -= String.valueOf(currentNum).length(); 
		}
		return pyramid;
	}

	private static String getEmptySpaces(int indentationThisLine) {
		String emptySpaces = "";
		for(int i = 0; i < indentationThisLine; i++) {
			emptySpaces += " ";
		}
		return emptySpaces;
	}

	private static int getFinalLineLength(int topOfPyramidNum, int numLevels) {
		int numSpaces = 0;
		for(int rowNumber = 0; rowNumber < numLevels; rowNumber++) {
			int spacesOccupiedByNumber = String.valueOf(topOfPyramidNum).length();
			numSpaces += spacesOccupiedByNumber; // The first occurrence of the number on the row
			numSpaces += rowNumber > 0 ? spacesOccupiedByNumber : 0; // The second occurrence of the number on the row
			topOfPyramidNum++;
		}
		return numSpaces % 2 == 0 ? numSpaces : numSpaces + 1;
	}
}
