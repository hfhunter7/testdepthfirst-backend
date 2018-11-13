package com.example.testdepthfirstapp.utils;

public class Constant {

	public static final String SECRET_KEY = "%me!dMA2g$3eXjfgIpJ80*D0ThxaOygU";
	
	public static final String APP_TOKEN = "example@version1.0.0";
	
	public static final String CURRENT_TIME = System.currentTimeMillis() + "|";

	public static final String IMAGE_PATH = "http://res.cloudinary.com/testhero2/image/upload/testherov2/";

	public static final String MEDIA_FOLDER = "media/";

	public static final String IMAGE_PATH_VERSION_ONE = "http://res.cloudinary.com/testhero2/image/upload/v1/testherov2/";

	public static interface APP_NAME {
		public static final String TEACHER = "trainer";
		public static final String STUDENT = "student";
		public static final String ADMIN = "admin";
	}

	public static interface SECTION_ITEM_TYPE {
		public static final String VIDEO = "video";
		public static final String PDF = "pdf";
		public static final String QUIZ = "quiz";
	}

	public static interface CART_ITEM_TYPE {
		public static final String COURSE = "course";
		public static final String CERTIFICATE = "certificate";
	}

	public static interface ORDER_ITEM_TYPE {
		public static final String COURSE = "course";
		public static final String CERTIFICATE = "certificate";
	}

	public static interface MY_TRAINING_TYPE {
		public static final String COURSE = "course";
		public static final String CERTIFICATE = "certificate";
	}

	public static interface MY_TRAINING_ITEM_TYPE {
		public static final String VIDEO = "video";
		public static final String PDF = "pdf";
		public static final String QUIZ = "quiz";
	}

	public static interface ROLE {
		public static final String TEACHER = "Trainer";
		public static final String STUDENT = "Trainee";
		public static final String Admin = "admin";
	}

	public static interface STATUS {
		public static final String ACTIVE = "active";
		public static final String INACTIVE = "inactive";
	}

	public static interface RESPONSE {
		public static interface STATUS {
			public static final int EXCEPTION = 500;
			public static final int SUCCESS = 200;
			public static final int BAD_REQUEST = 400;
			public static final int INVALID_TOKEN = 401;
			public static final int INVALID_APP_TOKEN = 401;
			public static final int INTERNAL_SERVER_ERROR = 500;
			public static final int INVALID_PARAMETERS = 402;
			public static final int INPUT_TIME_OVERLAP = 403;
			public static final int INVALID_FILE = 404;
			public static final int EXIST_DATA = 201;
		}

		public static interface MSG {
			public static final String EXCEPTION = "internal server error";
			public static final String SUCCESS = "ok";
			public static final String UNAUTHORIZED = "unauthorized";
			public static final String BAD_REQUEST = "bad request";
			public static final String INVALID_TOKEN = "invalid token";
			public static final String INVALID_APP_TOKEN = "invalid app token";
			public static final String INTERNAL_SERVER_ERROR = "internal server error";
			public static final String DATA_NOT_FOUND = "data not found";
			public static final String INVALID_PARAMETERS = "invalid parameters";
			public static final String DATA_DUPLICATED = "data is duplicated";
			public static final String USER_DUPLICATED = "user is duplicated";
			public static final String INPUT_TIME_OVERLAP = "time is overlap";
			public static final String INVALID_FILE = "invalid file";
			public static final String USER_NOT_FOUND = "user not found";
			public static final String USER_NOT_VERIFIED_EMAIL = "user not verified email";
			public static final String PASSWORD_INCORRECT = "password incorrect";
			public static final String PASSWORD_NOT_MATCH = "password not match";
			public static final String REQUIRED_FIELD = "required field";
			public static final String FACEBOOK_CONNECTED = "This facebook account is already connected to another user";
			public static final String NOT_DISCONNECT_FACEBOOK = "Could not disconnect facebook account";
			public static final String GOOGLE_CONNECTED = "This google account is already connected to another user";
			public static final String NOT_DISCONNECT_GOOGLE = "Could not disconnect google account";
		}
	}

	public static interface SERVICE {
		public static final String EMAIL = "email";
		public static final String FACEBOOK = "facebook";
		public static final String GOOGLE = "google";
		public static final String LOGIN = "login";
		public static final String REGISTER = "register";
		public static final String LOGIN_RESULT = "login_result";
	}
}
