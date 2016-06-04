public class NumIslands_unionFind {
    private int n; // num of row
    private int m; // num of colomn
    private int[] parents;
    private int[] size;
    private boolean[] ifOpen;
    private int blockCount;
    private int count; // track num of island
    public NumIslands_unionFind(char[][] grid) {
        n = grid.length;
        m = grid[0].length;
        count = n*m;
        blockCount = n*m;
        parents = new int[n*m];
        size = new int[n*m];
        ifOpen = new boolean[n*m];
        for (int o = 0; o< n*m; o++) {
            parents[o] = o;
            size[o] = 1;
            ifOpen[o] = false;
        }

        for (int i = 0; i< n; i++) {
            for (int j = 0; j< m; j++) {
                if (grid[i][j] == '1') {

                    open(i, j);
                }
            }
        }
    }
    private boolean valide(int i, int j) {
        return (i >= 0 && i < n) && (j >= 0 && j < m);
    }
    private boolean valide(int p) {
        if (p < 0 && p >= n) {
            System.out.println("error");
            return false;
        }
        else {
            return true;
        }
    }

    private int find(int p) {
        valide(p);
        while(parents[p] != p) {
            p = parents[p];
        }
        return p;
    } 
    public int count() {
        return count;
    }
    public int blockCount() {
        return blockCount;
    }    

    private void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (size[rootP] < size[rootQ]) {
            parents[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        else {
            parents[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
        count--;
    }

    private boolean ifOpen(int i, int j) {
        return ifOpen[i*m+j];
    }  

    private void open(int i, int j) {
        ifOpen[i*m+j]=true;
        blockCount--;

        if (valide(i-1,j)) { //up
            if (ifOpen(i-1, j)) {
                if (find(i*m+j)!=find((i-1)*m+j)) {                

                    //System.out.println(i +" "+j);
                    union(i*m+j, (i-1)*m+j);
                }
            }            
        }

        
        if (valide(i+1,j)) { //down
            if (ifOpen(i+1, j)) {
                if (find(i*m+j)!=find((i+1)*m+j)) {                        
                    union(i*m+j, (i+1)*m+j);
                    //System.out.println(i +" "+j);
                }   
            }            
        }

        
        if (valide(i,j-1)) { //left
            if (ifOpen(i, j-1)) {
                if (find(i*m+j)!=find(i*m+(j-1))) {                    
                    union(i*m+j, i*m+(j-1));
                    //System.out.println(i +" "+j);
                }
            }
        }

        if (valide(i,j+1)) { //right
            if (ifOpen(i, j+1)) {
                if (find(i*m+j)!=find(i*m+(j+1))) {                    
                    union(i*m+j, i*m+(j+1));
                    //System.out.println(i +" "+j);
                }
            }
        }

    }

    public static void main(String[] args) {
        //char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        //char[][] grid =  {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        char[][] grid = {
        {'1','1','1'},
        {'0','1','0'},
        {'1','1','1'}};
        NumIslands_unionFind is = new NumIslands_unionFind(grid); 
        //System.out.println(is.count());
        //System.out.println(is.blockCount());
        System.out.println(is.count()-is.blockCount());
    }
}