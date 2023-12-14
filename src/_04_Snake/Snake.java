package _04_Snake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

public class Snake {
	public static final Color SNAKE_COLOR = Color.BLUE;
	public static final int BODY_SIZE = 50;

	private SnakeSegment head;
	private ArrayList<SnakeSegment> snake;

	private Direction currentDirection;

	private boolean canMove = true;

	public Snake(Location location) {
		snake = new ArrayList<SnakeSegment>();
		head = new SnakeSegment(location, BODY_SIZE);
		snake.add(head);
		currentDirection = Direction.RIGHT;
	}

	public void feed() {
		snake.add(new SnakeSegment(snake.get(0).getLocation(), BODY_SIZE));
	}

	public Location getHeadLocation() {
		return head.getLocation();
	}


	public void update() {
		    int nextX = head.getLocation().x;
		    int nextY = head.getLocation().y;

		    switch (currentDirection) {
		        case UP:
		            nextY--;
		            break;
		        case DOWN:
		            nextY++;
		            break;
		        case LEFT:
		            nextX--;
		            break;
		        case RIGHT:
		            nextX++;
		            break;
		    }

		    for (int i = snake.size() - 1; i > 0; i--) {
		        SnakeSegment current = snake.get(i);
		        SnakeSegment previous = snake.get(i - 1);
		        current.setLocation(previous.getLocation());
		    }

		    head.setLocation(new Location(nextX, nextY));
		    canMove = true;
		}
		/*
		 * Create variables for the next X and Y location of the snake's head.
		 * Initialize them to the current X and Y locations.
		 */

		/*
		 * Use a switch statement to check on the currentDirection of the snake and
		 * calculate the head's next x and y position. Depending on the direction, the
		 * variables you created may increase or decrease by 1.
		 */

		/*
		 * Change the Location of each SnakeSegment in your snake ArrayList to the
		 * Location of the segment in front of it.
		 * 
		 * Use a loop starting at the end of the ArrayList and stop before the head of
		 * the snake (index 0) or you will go out of bounds.
		 */

		/*
		 * Create a new Location object and initialize it with the values calculated in
		 * the first step. Then set the head's location equal to the new location.
		 */

		// Set the canMove member variable to true.

	

	public void setDirection(Direction direction) {
	    if (isNotOppositeDirection(direction) && canMove) {
	        currentDirection = direction;
	        canMove = false;
	    }
	}

	private boolean isNotOppositeDirection(Direction direction) {
	    switch (currentDirection) {
	        case UP:
	            return direction != Direction.DOWN;
	        case DOWN:
	            return direction != Direction.UP;
	        case LEFT:
	            return direction != Direction.RIGHT;
	        case RIGHT:
	            return direction != Direction.LEFT;
	        default:
	            return true; 
	    }
	}

	public void resetLocation() {
		// Clear the snake.

		/*
		 * Create a new Location object for the head at SnakeGame.WIDTH / 2,
		 * SnakeGame.HEIGHT / 2.
		 */

		/*
		 * Set the head member variable equal to a new SnakeSegment object. Use the
		 * Location created in step 2 for the Location and the BODY_SIZE constant for
		 * the size.
		 */

		// Add the head to the snake.
	    snake.clear();
	    
	    Location newLocation = new Location(SnakeGame.WIDTH / 2, SnakeGame.HEIGHT / 2);
	    head = new SnakeSegment(newLocation, BODY_SIZE);
	    snake.add(head);
	}
	
	public boolean isHeadCollidingWithBody() {

		/*
		 * Complete the method so it returns true if the head is located in the same
		 * location as any other body segment.
		 */
		for (int i = snake.size() - 1; i > 0; i--) {
	        SnakeSegment current = snake.get(i);
	        SnakeSegment previous = snake.get(i - 1);
	        if(current.getLocation().x == previous.getLocation().x && current.getLocation().y == previous.getLocation().y) {
	        	return true;
	        }
	    }

		return false;
	}

	public boolean isLocationOnSnake(Location loc) {

		/*
		 * Complete the method so it returns true if the passed in location is located
		 * on the snake.
		 */
		
		for (SnakeSegment segment : snake) {
	        if (segment.getLocation().equals(loc)) {
	            return true;
	        }
	    }
		return false;
	}

	public void draw(Graphics g) {
		for (SnakeSegment s : snake) {
			s.draw(g);
		}
	}
}
