public class BinarySearchTree {
	 public TreeNode root;

	public boolean insert(int value,String info){
		if (root==null){
			root=new TreeNode(value,info);
			return true;
		}
		TreeNode current=root;
		while (true){
			if (current.value==value){
				return false;
			}
			if (value<current.value){
				if (current.leftChild==null){
					current.leftChild=new TreeNode(value,info);
					return true;
				}else{
					current=current.leftChild;
					continue;
				}
			}
			if (value>current.value){
				if (current.rightChild==null){
					current.rightChild=new TreeNode(value,info);
					return true;
				}else{
					current=current.rightChild;
					continue;
				}
			}
		}
	}

	public String query(int value){
		TreeNode current=root;
		while(current!=null){
			if (value<current.value){
				current=current.leftChild;
				continue;
			}

			if (value> current.value){
				current=current.rightChild;
				continue;
			}

			return current.info;
		}
		return null;
	}

	public boolean delete(int value){
		TreeNode current=root;
		TreeNode parent=null;
		boolean isLeftChild=true;

		/**find the node need to delete, if node doesn't exist,return false*/
		while(current!=null&&current.value!=value){
			parent=current;
			if (value< current.value){
				isLeftChild=true;
				current=current.leftChild;
			}else {
				isLeftChild=false;
				current=current.rightChild;
			}
		}
		if (current==null){
			return false;
		}

		/**node dont have child
		 * if not parent->this node is root
		 * if isLeftChild, set parent left child null
		 * else if !isLeftChild,set parent right child null*/
		if (current.leftChild==null&&current.rightChild==null){
			if (parent==null){
				root=null;
			} else if (isLeftChild) {
				parent.leftChild=null;
			}else{
				parent.rightChild=null;
			}
			return true;
		}

		/**
		 * 1.only left child.
		 * 1.1 its root-> root=left child
		 * 1.2 isLeftChild->parent.left=current.left
		 * 1.3 !isLeftChild->parent.right=current,left
		 *
		 * 2.only right child ......
		 * */
		if (current.leftChild==null&&current.rightChild!=null){
			if (parent==null){
				root=current.rightChild;
				return true;
			}
			if (isLeftChild){
				parent.leftChild=current.rightChild;
			}else{
				parent.rightChild=current.rightChild;
			}
			return true;
		}


		if(current.leftChild!=null&&current.rightChild==null){
			if (parent==null){
				root=current.leftChild;
				return true;
			}
			if (isLeftChild){
				parent.leftChild=current.leftChild;
			}else{
				parent.rightChild=current.leftChild;
			}
			return true;
		}

		/**
		 * Two child (go find largest node in left)*/
		TreeNode succession=current.leftChild;
		TreeNode successionParent=current;

		while(succession.rightChild!=null){
			successionParent=succession;
			succession=succession.rightChild;
		}
		successionParent.rightChild=succession.leftChild;
		succession.leftChild=current.leftChild;
		succession.rightChild=current.rightChild;

		if (parent==null){
			root=succession;
		}else if (isLeftChild){
			parent.leftChild=succession;
		}else{
			parent.leftChild=succession;
		}
		return true;
	}

	/**
	 * leftChild->node->rightChild*/
	public void inOrdertraverse(TreeNode node){
		if (node.leftChild!=null){
			inOrdertraverse(node.leftChild);
		}
		System.out.print(node.value+ " ");
		if (node.rightChild!=null){
			inOrdertraverse(node.rightChild);
		}
	}

	/**node->leftChild->rightChild**/
	public void preOrdertraverse(TreeNode node){
		System.out.print(node.value+ " ");
		if (node.leftChild!=null){
			preOrdertraverse(node.leftChild);
		}
		if (node.rightChild!=null){
			preOrdertraverse(node.rightChild);
		}
	}

	/**leftChild->rightChild->node*/
	public void postOrdertraverse(TreeNode node){
		if (node.leftChild!=null){
			postOrdertraverse(node.leftChild);
		}
		if (node.rightChild!=null){
			postOrdertraverse(node.rightChild);
		}
		System.out.print(node.value+ " ");
	}

	private class TreeNode{
	int value;
	String info;
	TreeNode leftChild;
	TreeNode rightChild;

		public TreeNode(int value, String info) {
			this.value = value;
			this.info=info;

		}
	}
}
