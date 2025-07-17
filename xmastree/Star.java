package xmastree;

public class Star extends TreeDecorator {
		
		public Star(Tree tree) {
			if (!tree.hasStar()) {   // check through delegation whether the tree already has a star
				tree.setStar();
				 this.tree=new RealStar(tree); // now wrap it with the real star decorator object
			}
			else { // else we didn't have a star
				System.out.println("Tree already has a star!");
				this.tree=tree;
			}
		}
		
		public String getDescription() {
			return tree.getDescription();
		}

		public double cost() {
			return tree.cost();  // check nothing
	    }

}
