class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char number = board[i][j];
                
                if (number != '.') {
                    // Create unique keys for each constraint
                    String rowKey = number + " in row " + i;
                    String colKey = number + " in col " + j;
                    String boxKey = number + " in box " + i/3 + "-" + j/3;
                    
                    // .add() returns false if the element is already present
                    if (!seen.add(rowKey) || !seen.add(colKey) || !seen.add(boxKey)) {
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
}
