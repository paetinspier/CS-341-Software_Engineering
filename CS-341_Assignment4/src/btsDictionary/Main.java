package btsDictionary;

public class Main {

	public static void main(String[] args) {
		
		Tree myTree = new Tree();
		
		myTree.insertWordNode("lighter");
		myTree.insertWordNode("butt");
		myTree.insertWordNode("face");
		myTree.insertWordNode("damn");
		myTree.insertWordNode("excited");
		myTree.insertWordNode("funny");
		myTree.insertWordNode("eight");
		myTree.insertWordNode("hammer");
		myTree.insertWordNode("iron");
		myTree.insertWordNode("pagaille");
		
		myTree.inOrderTreeSearch(myTree.getRoot());
		
		myTree.deleteWordNode("pagaille");
		myTree.deleteWordNode("face");
		myTree.deleteWordNode("butt");
		myTree.deleteWordNode("funny");
		
		System.out.println("   ");
		
		myTree.inOrderTreeSearch(myTree.getRoot());
		
		
		System.out.println(myTree.spellCheck("eight"));
		
	}

}
