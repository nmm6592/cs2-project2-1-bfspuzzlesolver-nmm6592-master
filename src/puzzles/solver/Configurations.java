package puzzles.solver;

import java.util.Collection;

public interface Configurations {
    Collection< Configurations > getsuccessors();

    Boolean isgoal();

}
