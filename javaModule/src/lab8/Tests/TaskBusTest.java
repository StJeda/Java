package lab8.Tests;

import lab8.TaskBus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskBusTest {

    @Test
    public void testRunBusSystem() throws InterruptedException {
        TaskBus.runBusSystem();

        assertDoesNotThrow(() -> TaskBus.runBusSystem());
    }
}
