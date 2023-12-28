package com.boltkrank.webconsumer;

public class Consumer {
    
    private String iterations;
    private String level;
    private boolean running;

    public Consumer(){
        this.running = false;
    }

    public String getIterations(){
        return iterations;
    }

    public void setIterations(String iterations){
        this.iterations = iterations;
    }

    public String getLevel(){
        return level;
    }

    public void setLevel(String level){
        this.level = level;
    }

    public void setRunning(boolean running){
        this.running = running;
    }

    public boolean getRunning(){
        return running;
    }

    /**
     * 
     */
    public void runConsumption(){

        setRunning(true);
        System.out.println("Running");

        int tmp_iter = Integer.getInteger(getIterations());
        int tmp_level = 0;
        if (getLevel().equals("low")){
            tmp_level = 1;
        }
        else if (getLevel().equals("medium")){
            tmp_level = 2;
        }
        else {
            tmp_level = 3;
        }

        System.out.println("Iterations: " + tmp_iter + "\nLevel: " + tmp_level);

        setRunning(false);
        System.out.println("Finished Running");

    }

}
