/**
 * @author yonyong
 * @version 1.0
 * @date 2022/11/8 21:25
 */
class OrgCodeCompare {

    boolean NonCompliantEquals(OrgInfo orgInfo){
        return "NJ001".equals(orgInfo.getOrgCode());
    }

    boolean NonCompliantEquals2(OrgInfo orgInfo){
        return orgInfo.getOrgCode().equals("NJ001");
    }

    boolean CompliantEquals(OrgInfo orgInfo){
        return "NJ002".equals(orgInfo.getOrgCode().trim());
    }

    boolean CompliantEquals(OrgInfo orgInfo){
        return orgInfo.getOrgCode().trim().equals("NJ002");
    }


    class OrgInfo {
        public String orgCode;

        public String getOrgCode() {
            return orgCode;
        }

        public void setOrgCode(String orgCode) {
            this.orgCode = orgCode;
        }
    }
}
