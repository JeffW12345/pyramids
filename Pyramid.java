public class Pyramid {
		
	public static void main(String args[]) {
		String pyramid = getPyramid(997, 10);
		System.out.println(pyramid);
	}

	private static String getPyramid(int topOfPyramidNum, int numLevels) {
		int lenTerminatingNumber = String.valueOf(topOfPyramidNum + numLevels).length();
		int lenTerminatingLine = getFinalLineLength(topOfPyramidNum, numLevels);
		int spacesBeforeNumOnRight = (lenTerminatingLine / 2) - (lenTerminatingNumber / 2);
		int spacesBeforeNumOnLeft = 0;
		int currentNum = topOfPyramidNum;
		int prevNum = 0;
		String pyramid = "";
		for(int rowNum = 0; rowNum < numLevels; rowNum++) {
			pyramid += getIndentation(spacesBeforeNumOnRight);
			pyramid += currentNum;
			if(rowNum == 1) {
				spacesBeforeNumOnLeft = String.valueOf(prevNum).length();
			}
			if(rowNum > 1) {
				spacesBeforeNumOnLeft += (String.valueOf(prevNum).length() * 2);
			}
			pyramid += rowNum > 0 ? getIndentation(spacesBeforeNumOnLeft) : ""; 
			pyramid += rowNum > 0 ? currentNum : "";
			pyramid += "\n";
			prevNum = currentNum;
			currentNum++;
			spacesBeforeNumOnRight -= String.valueOf(currentNum).length(); 
		}
		return pyramid;
	}

	private static String getIndentation(int indentationThisLine) {
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
			numSpaces += spacesOccupiedByNumber; // The left occurrence of the number
			numSpaces += rowNumber > 0 ? spacesOccupiedByNumber : 0; // The right occurrence of the number
			topOfPyramidNum++;
		}
		return numSpaces % 2 == 0 ? numSpaces : numSpaces + 1;
	}
}
