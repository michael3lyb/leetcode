public class NumIslands_good {
    char[][] g;
    private int islands = 0;
    public NumIslands_good(char[][] grid) {

            g = grid;
            for (int i=0; i<g.length; i++) {
                for (int j=0; j<g[i].length; j++) {
                    islands += sink(i, j);
                }
            }
    }

    public int result() {
        return islands;
    }

    int sink(int i, int j) {
            if (i < 0 || i == g.length || j < 0 || j == g[i].length || g[i][j] == '0') {
                return 0;
            }
            g[i][j] = '0';
            sink(i+1, j); 
            sink(i-1, j); 
            sink(i, j+1); 
            sink(i, j-1);
            return 1;
    }

    public static void main(String[] args) {
        //char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
//        char[][] grid =  {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        char[][] grid = {
        {'1','1','1'},
        {'0','1','0'},
        {'1','1','1'}};

        NumIslands_good uf = new NumIslands_good(grid);

        System.out.println(uf.result());
    }    
}