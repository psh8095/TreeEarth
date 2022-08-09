package vo.member;


public class AuthDTO {

	/*

	CREATE DATABASE treeEarth;

	CREATE TABLE auth (
	    mem_email VARCHAR(50) PRIMARY KEY, 
	    mem_auth VARCHAR(20),
	    mem_auth_count INT
	 );
	 */

		
		private String mem_email;
		private String mem_auth;
		private String mem_auth_count;
		
		
		public String getMem_email() {
			return mem_email;
		}
		public void setMem_email(String mem_email) {
			this.mem_email = mem_email;
		}
		public String getMem_auth() {
			return mem_auth;
		}
		public void setMem_auth(String mem_auth) {
			this.mem_auth = mem_auth;
		}
		public String getMem_auth_count() {
			return mem_auth_count;
		}
		public void setMem_auth_count(String mem_auth_count) {
			this.mem_auth_count = mem_auth_count;
		}
		
	}

