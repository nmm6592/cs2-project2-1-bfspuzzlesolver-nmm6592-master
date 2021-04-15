package puzzles.water;

import puzzles.solver.Configurations;
import puzzles.solver.Solver;

import java.util.Collection;

public class Water implements Configurations {
    private int[] buckets;
    private int water;

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println(("Usage: java Water amount bucket1 bucket2 ..."));
        }

    }

    @Override
    public Collection<Configurations> getsuccessors() {
        return null;
    }

    @Override
    public Boolean isgoal() {
        return null;
    }
}
