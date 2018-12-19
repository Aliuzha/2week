package ossome.issueApp.datasource;

public enum JdbcQuery {
	GET_ALL_ISSUES{
		public String toString() {
			return "SELECT * FROM ISSUE_ISSUEAP";
		}
	},
	
	GET_AN_ISSUE{
		public String toString() {
			return "SELECT * FROM ISSUE_ISSUEAP WHERE ISSUE_ISSUEAP.ID = ?";
		}
	},
	
	CREATE_AN_ISSUE_ACTIVITY{
		public String toString() {
			return "INSERT INTO ISSUE_ISSUEAP values (ISSUE_ISSUEAPP_ID.nextval, CURRENT_DATE, ? , ?, null, ?, null, ?, ?, 'Activity Error');";
		}
	},
	
	REMOVE_AN_ISSUE{
		public String toString() {
			return "";
		}
	},

	UPDATE_AN_ISSUE{
		public String toString() {
			return "";
		}
	}
	
}
