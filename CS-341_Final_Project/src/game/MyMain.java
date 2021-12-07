package game;

public class MyMain {

	public static void main(String[] args) {

		// TASK 1: CREATE A CANVAS FOR ANIMATION
		Canvas canvas = new Canvas();
		canvas.requestFocus();

		// TASK 2: ADD A USER GAME OBJECT
		Type_A_GameObject a = new Type_A_GameObject(200, 200);

		canvas.addKeyListener(a);
		canvas.addGameObject(a);

		Type_C_GameObject c = new Type_C_GameObject(200, 200);

		canvas.addKeyListener(c);
		canvas.addGameObject(c);

		Type_D_GameObject d = new Type_D_GameObject(200, 200);

		canvas.addKeyListener(d);
		canvas.addGameObject(d);

	}

}
