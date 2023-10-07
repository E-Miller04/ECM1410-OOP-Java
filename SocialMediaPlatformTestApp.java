import socialmedia.*;

import java.io.IOException;

/**
 * A short program to illustrate an app testing some minimal functionality of a
 * concrete implementation of the SocialMediaPlatform interface -- note you will
 * want to increase these checks, and run it on your SocialMedia class (not the
 * BadSocialMedia class).
 *
 * 
 * @author Diogo Pacheco
 * @version 1.0
 */
public class SocialMediaPlatformTestApp {

	/**
	 * Test method.
	 * 
	 * @param args not used
	 */
	public static void main(String[] args) {
		System.out.println("The system compiled and started the execution...");

		SocialMediaPlatform platform = new SocialMedia();
		//System.out.println(platform.createAccount("Lilyyyyy"));



		/* assert (platform.getNumberOfAccounts() == 0) : "Innitial SocialMediaPlatform not empty as required.";
		assert (platform.getTotalOriginalPosts() == 0) : "Innitial SocialMediaPlatform not empty as required.";
		assert (platform.getTotalCommentPosts() == 0) : "Innitial SocialMediaPlatform not empty as required.";
		assert (platform.getTotalEndorsmentPosts() == 0) : "Innitial SocialMediaPlatform not empty as required.";
		*/
		Integer id, id2, id3, id4;

		//creating accounts
		try {
			id = platform.createAccount("my_handle");
			id2 = platform.createAccount("ellen");
			id3 = platform.createAccount("a", "i am a description");

			/*
			assert (platform.getNumberOfAccounts() == 1) : "number of accounts registered in the system does not match";

			Remove to separate try

			platform.removeAccount(id);
			assert (platform.getNumberOfAccounts() == 0) : "number of accounts registered in the system does not match";
			*/

			System.out.println("ID = " + id);
			System.out.println("ID 2 = " + id2);
			System.out.println("ID 3 = " + id3);
		} catch (IllegalHandleException e) {
			assert (false) : "IllegalHandleException thrown incorrectly";
			System.out.println("Illegal");
		} catch (InvalidHandleException e) {
			assert (false) : "InvalidHandleException thrown incorrectly";
			System.out.println("Invalid");
		} /* catch (AccountIDNotRecognisedException e) {
			assert (false) : "AccountIDNotRecognizedException thrown incorrectly";
		} */
		//changing handle of account
		try {
			platform.changeAccountHandle("a", "aaa");
		} catch (HandleNotRecognisedException e) {
			assert (false) : "blaaa";
			System.out.println("Handle not recognised");
		} catch (IllegalHandleException e) {
			assert (false) : "IllegalHandleException thrown incorrectly";
			System.out.println("Illegal");
		} catch (InvalidHandleException e) {
			assert (false) : "InvalidHandleException thrown incorrectly";
			System.out.println("Invalid");
		}
		//changing desciption of account
		try {
			platform.updateAccountDescription("aaa", "weeeee");
		} catch (HandleNotRecognisedException e) {
			assert (false) : "blaaa";
			System.out.println("Handle not recognised");
		}
		//showing accounts
		try {
			System.out.println(platform.showAccount("my_handle"));
			System.out.println(platform.showAccount("ellen"));
			System.out.println(platform.showAccount("aaa"));
		} catch (HandleNotRecognisedException e) {
			assert (false) : "blaaa";
			System.out.println("Handle not recognised");
		}

		// Num of accounts
		System.out.println(platform.getNumberOfAccounts());

		// check removing account works
		try {
			platform.removeAccount(5);
			System.out.println(platform.getNumberOfAccounts());
		} catch (AccountIDNotRecognisedException e) {
			System.out.println("ID not recognised");
		}
		try {
			platform.removeAccount("ellen");
			System.out.println(platform.getNumberOfAccounts());
		} catch (HandleNotRecognisedException e) {
			System.out.println("Handle not recognised");
		}

		System.out.println("\n Post stuff:");

		// check create post works
		try {
			System.out.println(platform.createPost("my_handle", "beep boop :)"));
		} catch (HandleNotRecognisedException e) {
			System.out.println("fdf");
		} catch (InvalidPostException e) {
			System.out.println("hbhgftd");
		}

		// display post
		try {
			System.out.println(platform.showIndividualPost(1));
		} catch (PostIDNotRecognisedException e){
			System.out.println("ID not recognised");
		}

		// create comment
		try {
			System.out.println(platform.commentPost("aaa", 1, "I am a message"));
			System.out.println(platform.showIndividualPost(2));
		} catch (HandleNotRecognisedException e) {
			System.out.println("Handle");
		} catch (PostIDNotRecognisedException e) {
			System.out.println("post id");
		} catch (NotActionablePostException e) {
			System.out.println("not actionable");
		} catch (InvalidPostException e) {
			System.out.println("invalid message");
		}

		// check getnumberof
		System.out.println(platform.getTotalOriginalPosts());
		System.out.println(platform.getTotalCommentPosts());

		// check endorse post works (id=3)
		try {
			System.out.println(platform.endorsePost("aaa", 1));
		} catch (HandleNotRecognisedException e) {
			System.out.println("Handle");
		} catch (PostIDNotRecognisedException e) {
			System.out.println("post id");
		} catch (NotActionablePostException e) {
			System.out.println("not actionable");
		}

		// check commenting on an endorsement DOESNT WORK
		try {
			System.out.println(platform.commentPost("aaa", 3, "I should fail"));
			System.out.println(platform.showIndividualPost(2));
		} catch (HandleNotRecognisedException e) {
			System.out.println("Handle");
		} catch (PostIDNotRecognisedException e) {
			System.out.println("post id");
		} catch (NotActionablePostException e) {
			System.out.println("not actionable");
		} catch (InvalidPostException e) {
			System.out.println("invalid message");
		}

		System.out.println(platform.getTotalEndorsmentPosts());

		try {
			System.out.println(platform.showIndividualPost(1));
		} catch (PostIDNotRecognisedException e) {
			System.out.println("post id not recognised");
		}


		// make another account
		try {
			id4 = platform.createAccount("lily", "descriptionnnnn");

			System.out.println("ID4 = " + id4);
		} catch (IllegalHandleException e) {
			assert (false) : "IllegalHandleException thrown incorrectly";
			System.out.println("Illegal");
		} catch (InvalidHandleException e) {
			assert (false) : "InvalidHandleException thrown incorrectly";
			System.out.println("Invalid");
		}


		// make more posts and endorsements
		try {
			System.out.println(platform.createPost("lily", "i like dogs"));
		} catch (HandleNotRecognisedException e) {
			System.out.println("handle not recognised");
		} catch (InvalidPostException e) {
			System.out.println("invalid");
		}


		// endorse another post twice
		try {
			System.out.println(platform.endorsePost("my_handle", 4));
			System.out.println(platform.endorsePost("aaa", 4));
		} catch (HandleNotRecognisedException e) {
			System.out.println("Handle");
		} catch (PostIDNotRecognisedException e) {
			System.out.println("post id");
		} catch (NotActionablePostException e) {
			System.out.println("not actionable");
		}



		System.out.println("Most endorsed post = "+platform.getMostEndorsedPost());

		System.out.println("Most endorsed account = "+platform.getMostEndorsedAccount());


		//showing accounts

		try {
			System.out.println("Lily Account:\n" + platform.showAccount("lily"));
		} catch (HandleNotRecognisedException e) {
			assert (false) : "blaaa";
			System.out.println("Handle not recognised");
		}


		// creating more comments on postID 1 to make it more interesting

		// create comment
		try {
			System.out.println(platform.commentPost("lily", 1, "boop beep"));

		} catch (HandleNotRecognisedException e) {
			System.out.println("Handle");
		} catch (PostIDNotRecognisedException e) {
			System.out.println("post id");
		} catch (NotActionablePostException e) {
			System.out.println("not actionable");
		} catch (InvalidPostException e) {
			System.out.println("invalid message");
		}

		// create comment
		try {
			System.out.println(platform.commentPost("aaa", 7, "hello fellow beep boops"));
		} catch (HandleNotRecognisedException e) {
			System.out.println("Handle");
		} catch (PostIDNotRecognisedException e) {
			System.out.println("post id");
		} catch (NotActionablePostException e) {
			System.out.println("not actionable");
		} catch (InvalidPostException e) {
			System.out.println("invalid message");
		}

		// create comment
		try {
			System.out.println(platform.commentPost("aaa", 2, "commenting commenting..."));
		} catch (HandleNotRecognisedException e) {
			System.out.println("Handle");
		} catch (PostIDNotRecognisedException e) {
			System.out.println("post id");
		} catch (NotActionablePostException e) {
			System.out.println("not actionable");
		} catch (InvalidPostException e) {
			System.out.println("invalid message");
		}


		System.out.println("This is the dreaded StringBuilder");
		try {
			System.out.println(platform.showPostChildrenDetails(1));
		} catch (PostIDNotRecognisedException e) {
			System.out.println("ID");
		} catch (NotActionablePostException e) {
			System.out.println("Endo type");
		}


		System.out.println("\n\nThis is us deleting crap and seeing what happens:");
		try {
			platform.deletePost(4);
		} catch (PostIDNotRecognisedException e) {
			System.out.println("id not recognised");
		}


		try {
			System.out.println(platform.showPostChildrenDetails(1));
		} catch (PostIDNotRecognisedException e) {
			System.out.println("ID");
		} catch (NotActionablePostException e) {
			System.out.println("Endo type");
		}


		System.out.println("Removing accounts aaaaaaaaaa");
		try {
			platform.removeAccount("lily");
		} catch (HandleNotRecognisedException e) {
			System.out.println("handle not rec");
		//} catch (AccountIDNotRecognisedException e) {
		//	System.out.println("id");
		}


		try {
			System.out.println(platform.showPostChildrenDetails(1));
		} catch (PostIDNotRecognisedException e) {
			System.out.println("ID");
		} catch (NotActionablePostException e) {
			System.out.println("Endo type");
		}

		System.out.println("Scary platform stuff");

		try {
			platform.savePlatform("test.ser");
		} catch (IOException e) {
			System.out.println("did a whoopsie");
			e.printStackTrace();
		}

		/*
		try {
			platform.loadPlatform("test.ser");
		} catch (ClassNotFoundException e) {
			System.out.println(":(");
		} catch (IOException e) {
			System.out.println(":(");
		}
		*/

		//erase
		platform.erasePlatform();

		//new account and post
		// make another account
		try {
			id4 = platform.createAccount("pedro_pascal", "daddy");

			System.out.println("ID = " + id4);
		} catch (IllegalHandleException e) {
			assert (false) : "IllegalHandleException thrown incorrectly";
			System.out.println("Illegal");
		} catch (InvalidHandleException e) {
			assert (false) : "InvalidHandleException thrown incorrectly";
			System.out.println("Invalid");
		}


		// make more posts and endorsements
		try {
			System.out.println(platform.createPost("pedro_pascal", "I'm your daddy"));
		} catch (HandleNotRecognisedException e) {
			System.out.println("handle not recognised");
		} catch (InvalidPostException e) {
			System.out.println("invalid");
		}



		try {
			System.out.println("\n" + platform.showAccount("pedro_pascal"));
		} catch (HandleNotRecognisedException e) {
			assert (false) : "blaaa";
			System.out.println("Handle not recognised");
		}


		//redisplaying posts
		try {
			System.out.println("\n" + platform.showPostChildrenDetails(1));
		} catch (PostIDNotRecognisedException e) {
			System.out.println("ID");
		} catch (NotActionablePostException e) {
			System.out.println("Endo type");
		}

		System.out.println(platform.getNumberOfAccounts());
		System.out.println(platform.getTotalOriginalPosts());


		//reload and redisplay old posts
		try {
			platform.loadPlatform("test.ser");
		} catch (ClassNotFoundException e) {
			System.out.println(":(");
		} catch (IOException e) {
			System.out.println(":hjhjg");
		}

		try {
			System.out.println("\n" + platform.showPostChildrenDetails(1));
		} catch (PostIDNotRecognisedException e) {
			System.out.println("ID");
		} catch (NotActionablePostException e) {
			System.out.println("Endo type");
		}


		//new account and post
		// make another account
		try {
			id4 = platform.createAccount("pedro_pascal", "daddy");

			System.out.println("ID = " + id4);
		} catch (IllegalHandleException e) {
			assert (false) : "IllegalHandleException thrown incorrectly";
			System.out.println("Illegal");
		} catch (InvalidHandleException e) {
			assert (false) : "InvalidHandleException thrown incorrectly";
			System.out.println("Invalid");
		}
		// make more posts and endorsements
		try {
			System.out.println(platform.createPost("pedro_pascal", "I'm your daddy"));
		} catch (HandleNotRecognisedException e) {
			System.out.println("handle not recognised");
		} catch (InvalidPostException e) {
			System.out.println("invalid");
		}

		try {
			System.out.println("\n" + platform.showAccount("pedro_pascal"));
		} catch (HandleNotRecognisedException e) {
			assert (false) : "blaaa";
			System.out.println("Handle not recognised");
		}

		//redisplaying posts

		try {
			System.out.println("\n" + platform.showPostChildrenDetails(10));
		} catch (PostIDNotRecognisedException e) {
			System.out.println("ID");
		} catch (NotActionablePostException e) {
			System.out.println("Endo type");
		}


	}
}
