class Calculator {
    public int eval(String exp) {
        int sum = 0; // sum is initially 0 in java
        for(String sumx: exp.split("\\+")){
            sum += Integer.valueOf(sumx);
        }
        return sum;
    }
}
