import * as JWT from 'jwt-decode';
export class LoggedUtils {

    static getDecoded(){
        let decoded =JWT(JSON.parse(localStorage.getItem("loggedUser")).token);
        return decoded;
    }

    static getToken(){   
        if(this.isEmpty())
            return null;
        return JSON.parse(localStorage.getItem("loggedUser")).token;
    }
    static isEmpty(){
        return localStorage.getItem("loggedUser") === null;
    }

    
    static getRole(){
    if(LoggedUtils.getToken()!=null){
      let role:any=LoggedUtils.getDecoded();
      var userRole=role.role.authority;
    }
    return userRole;
  }
}
