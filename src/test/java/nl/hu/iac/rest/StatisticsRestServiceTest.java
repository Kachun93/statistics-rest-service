package nl.hu.iac.rest;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

public class StatisticsRestServiceTest {
    public List<Double> doubleList = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);
    public double expectedMean = 3.0;
    public double expectedStandardDeviation = 1.581;
    public double expectedVariance = 2.5;

    @Test
    public void calculateMean() throws Exception {
        StatisticsRestService service = new StatisticsRestService();

        double result = service.calculateMean(doubleList);

        assertEquals(expectedMean, result, 0.001);
    }

    @Test
    public void calculateVariance() throws Exception {
        StatisticsRestService service = new StatisticsRestService();

        double result = service.calculateVariance(doubleList);

        assertEquals(expectedVariance, result, 0.001);
    }

    @Test
    public void calculateStandardDeviation() throws Exception {
        StatisticsRestService service = new StatisticsRestService();

        double result = service.calculateStandardDeviation(doubleList);

        assertEquals(expectedStandardDeviation, result, 0.001);
    }

    @Test
    public void integrationTest() throws Exception {
        calculateMean();
        calculateVariance();
        calculateStandardDeviation();

        checkLastResult(expectedStandardDeviation);
    }

    private void checkLastResult(double expected) throws Exception {
        StatisticsRestService service = new StatisticsRestService();

        double result = service.getLastResult();
        assertEquals(expected, result, 0.001);
    }
}
