package simulation;

import java.util.ArrayList;
import java.util.List;

public class SimulationResult {
    private List<StepStatus> stepStatuses = new ArrayList<>();

    // adding step status
    public void addStepStatus(StepStatus stepStatus) {
        stepStatuses.add(stepStatus);
    }

    // getter
    public List<StepStatus> getStepStatuses() {return stepStatuses;}
}
