
        <form name="userinfo" method="post" action="adduserInfo">
            <div class="form-group">
                <label for="username">User Name</label>
                <input type="text" name="username" class="form-control" id="username">
                <div class="error-msg"><p style="color:red">Please Enter Name</p></div>
            </div>
            
             <div class="form-group">
                <label for="useraddress">User Address</label>
                <input type ="text" name="useraddress" class="form-control" id="useraddress"> 
                <div class="error-msg"><p style="color:red">Please Enter Address</p></div>
            </div>
                 <div class="form-group">
                <label for="userphone">User Phone</label>
                <input type="text" name="userphone" class="form-control" id="userphone"> 
                 <div class="error-msg"><p style="color:red">Please Enter Phone</p></div>
            </div>
               
            
            <div class="form-group">
                <label for="userphone">User Cell Phone</label>
                <input type="text" name="userphone" class="form-control" id="usercellphone"> 
                 <div class="error-msg"><p style="color:red">Please Enter Cell Phone</p></div>
            </div>
            
            <input name ="submit" type="submit" value="Add User" class="btn btn-default">
               
        </form>