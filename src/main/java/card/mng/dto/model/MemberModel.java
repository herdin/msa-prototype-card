package card.mng.dto.model;

import org.apache.ibatis.type.Alias;

@Alias("Member")
    public class MemberModel {
        private int userId;
        private String userName;
        private String useYn;

        public MemberModel(){};

        public MemberModel(int userId, String userName, String useYn) {
            this.userId = userId;
            this.userName = userName;
            this.useYn = useYn;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getUseYn() {
            return useYn;
        }

        public void setUseYn(String useYn) {
            this.useYn = useYn;
        }

        @Override
        public String toString() {
            return "MemberModel{" +
                    "userId=" + userId +
                    ", userName='" + userName + '\'' +
                    ", useYn='" + useYn + '\'' +
                    '}';
        }
}
