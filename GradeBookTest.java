import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GradeBookTest {

	GradeBook gradebook1;
	GradeBook gradebook2;

	@Before
	public void setUp() throws Exception 
	{
		gradebook1 = new GradeBook(5);
		gradebook1.addScore(76.3);
		gradebook1.addScore(92.1);
		gradebook1.addScore(88.7);

		gradebook2 = new GradeBook(5);
		gradebook2.addScore(77.3);
		gradebook2.addScore(100.0);
		gradebook2.addScore(95.8);
	}

	@After
	public void tearDown() throws Exception 
	{
		gradebook1 = null;
		gradebook2 = null;
	}

	@Test
	public void testAddScore() 
	{
		// Arrange
		int expectedNewScoreSize1 = gradebook1.getScoreSize() + 1;
		int expectedNewScoreSize2 = gradebook2.getScoreSize() + 1;

		String expectedScoresText1 = "76.3 92.1 88.7 69.6 ";
		String expectedScoresText2 = "77.3 100.0 95.8 79.9 ";
		

		// Act
		gradebook1.addScore(69.6);
		gradebook2.addScore(79.9);

		// Assert
		assertEquals(expectedNewScoreSize1, gradebook1.getScoreSize());
		assertEquals(expectedNewScoreSize2, gradebook2.getScoreSize());

		assertTrue(expectedScoresText1.equals(gradebook1.toString()));
		assertTrue(expectedScoresText2.equals(gradebook2.toString()));
	}

	@Test
	public void testSum() 
	{
		// Arrange 
		double expectedScore1 = 257.1;
		double expectedScore2 = 273.1;

		// Act
		double totalSum1 = gradebook1.sum();
		double totalSum2 = gradebook2.sum();

		// Assert
		assertEquals(expectedScore1, totalSum1, 0.0001);
		assertEquals(expectedScore2, totalSum2, 0.0001);
	}

	@Test
	public void testMinimum() 
	{
		// Arrange
		double expectedMinimum1 = 76.3;
		double expectedMinimum2 = 77.3;

		// Act
		double actualMin1 = gradebook1.minimum();
		double actualMin2 = gradebook2.minimum();

		// Assert
		assertEquals(expectedMinimum1, actualMin1, 0.0001);
		assertEquals(expectedMinimum2, actualMin2, 0.0001);
	}

	@Test
	public void testFinalScore() 
	{
		// Arrange
		double expectedFinalScore1 = 180.8;
		double expectedFinalScore2 = 195.8;

		// Act
		double actualFinalScore1 = gradebook1.finalScore();
		double actualFinalScore2 = gradebook2.finalScore();

		// Assert
		assertEquals(expectedFinalScore1, actualFinalScore1, 0.0001);
		assertEquals(expectedFinalScore2, actualFinalScore2, 0.0001);
	}
}
