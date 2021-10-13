package btsDictionary;

public class Tree {
	
	
	private Word root;
	
	public Tree() {
		root = null;
	}
	
	public void setRoot(Word root) {
		this.root = root;
	}
	public Word getRoot() {
		return root;
	}
	
	public void inOrderTreeSearch(Word node) {
		
		if (node == null) {
			return;
		}
		inOrderTreeSearch(node.getLeftKid());
		System.out.println(node.getKey() + " ");
		inOrderTreeSearch(node.getRightKid());
	}
	
	
	
	public void insertWordNode(String word) {
		
		
		assert !spellCheck(word): "The word " + word + " already exists in the dictionary."; // pre-condition
		
		// create a word out of the given string
		
		Word node = new Word();
		node.setKey(word);
		node.setParent(null);
		node.setLeftKid(null);
		node.setRightKid(null);
	
		
		// case 1: the tree is empty so we need to make the new word the root
		
		if (this.root == null) {
			this.root = node;
		}
		else {
			Word parentNode = null;
			Word temp = this.root;
			
			while (temp != null) { // this will find the parent node of the new node
				parentNode = temp;
				
				int comp = node.getKey().compareTo(temp.getKey());
				
				if(comp <= 0) {
					temp = temp.getLeftKid();
				}
				else {
					temp = temp.getRightKid();
				}
			}
			
			// set the parent node
			
			node.setParent(parentNode);
			
			if(node.getKey().compareTo(parentNode.getKey()) <= 0) {
				parentNode.setLeftKid(node);
			}
			else {
				parentNode.setRightKid(node);
			}
			
		}
	}// end of addWord()
	
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public boolean spellCheck(String search) {
		Word temp = this.root;
		
		while (temp != null && !temp.getKey().equals(search)) {
			if(search.compareTo(temp.getKey()) <= 0) {
				temp = temp.getLeftKid();
			}
			else {
				temp = temp.getRightKid();
			}
		}
		if(temp == null) {
			return false;
		}
		else {
			if (temp.getKey() == search){
				return true;
			}
			else {
				return false;
			}
		}

	}
	
	public static Word getMinWord(Word curr) {
		
		while (curr.leftKid != null) {
			curr = curr.leftKid;
		}
		return curr;
	}
	
	
	public Word deleteWordNode(String key) {
		
		
		assert spellCheck(key) && !isEmpty(): "the word " + key + " doesn't exist.";
		
		// first need to find the node
		
		Word parent = null;
		
		Word curr = this.root;
		
		while (curr != null && curr.getKey() != key) {
			
			parent = curr;
			
			if (curr.getKey().compareTo(key) <= 0) {
				curr = curr.rightKid;
			}
			else {
				curr = curr.leftKid;
			}
		}
		
		if (curr == null) {
			return this.root = null;
		}
		
		// for this method there are three cases:
		
		// case 1: delete a node with zero children. remove the node from the tree
		if (curr.leftKid == null && curr.rightKid == null) {
			
			if (curr != root) {
				
				if (parent.leftKid == curr) {
					parent.leftKid = null;
				}
				else {
					parent.rightKid = null;
				}	
			}
			else {
				root = null;
			}
			
			
		}
		
		
		// case 2: delete a node with two children. get the inorder successor and replace it with that.
		
		else if (curr.leftKid != null && curr.rightKid != null) {
			
			Word heir = getMinWord(curr.rightKid);
			
			String val = heir.getKey();
			
			deleteWordNode(heir.getKey());
			
			curr.setKey(val);
			
		}
		
		
		// case 3: delete a node with one child. replace the node with its child
		
		else {
			
			Word child = (curr.leftKid != null)? curr.leftKid: curr.rightKid;
			
			if (curr != root) {
				if(curr == parent.leftKid) {
					parent.leftKid = child;
				}
				else {
					parent.rightKid = child;
				}
			}
			else {
				root = child;
			}
		}
		
		assert spellCheck(key): "The word you are trying to delete can still be found in the tree. Error";
		
		return root;
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}// THE END













