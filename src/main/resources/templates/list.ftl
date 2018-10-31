<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">User </span></div>
		<div class="panel-body">
	        <div class="formcontainer">
	            <div class="alert alert-success" role="alert" ng-if="ctrl.successMessage">{{ctrl.successMessage}}</div>
	            <div class="alert alert-danger" role="alert" ng-if="ctrl.message">{{ctrl.message}}</div>
	            <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
	                <input type="hidden" ng-model="ctrl.user.id" />
	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="uname">Name</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrl.user.name" id="uname" class="username form-control input-sm" placeholder="Enter your name" required ng-minlength="3"/>
	                        </div>
	                    </div>
	                </div>

	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="eMail">E-mail</label>
	                        <div class="col-md-7">
	                            <input type="email" ng-model="ctrl.user.eMail" id="eMail" class="form-control input-sm" placeholder="Enter your Email." required ng-pattern="ctrl.eMailValid"/>
	                        </div>
	                    </div>
	                </div>
	
	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="address1">Address 1</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrl.user.addressLine1" id="address1" class="form-control input-sm" placeholder="Enter your address." required />
	                        </div>
	                    </div>
	                </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="address2">Address line 2</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.user.addressLine2" id="address2" class="form-control input-sm" placeholder="Enter your address"  />
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="townCity">Town/City</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.user.townCity" id="townCity" class="form-control input-sm" placeholder="Enter your Town o city ." required />
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="postalCode">Postal status</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.user.postalCode" id="postalCode" class="form-control input-sm" placeholder="Enter your postal status ."  />
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="country">Country</label>
                            <div class="col-md-7">
								<select ng-model="ctrl.user.country" id="country" class="form-control input-sm" required>
									<option value="">--select---</option>
									<option value="USA">USA</option>
                                    <option value="RUSSIA">RUSSIA</option>
                                    <option value="JAPAN">JAPAN</option>
                                    <option value="UK">UK</option>
                                    <option value="IRELAND">IRELAND</option>
                                    <option value="CHINA">CHINA</option>
                                    <option value="FRANCE">FRANCE</option>
                                    <option value="ITALY">ITALY</option>
								</select>
                                <!--input type="text" ng-model="ctrl.user.postalCode" id="postalCode" class="form-control input-sm" placeholder="Enter y ."  /-->
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="phoneNumber1">Phone number</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.user.phoneNumber1" id="phoneNumber1" class="form-control input-sm" placeholder="Enter your phone number"  />
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="phoneNumber2">Second Phone number</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.user.phoneNumber2" id="phoneNumber2" class="form-control input-sm" placeholder="Enter your second phone number"  />
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="phoneNumber2">Third Phone number</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.user.phoneNumber3" id="phoneNumber3" class="form-control input-sm" placeholder="Enter your third phone number"  />
                            </div>
                        </div>
                    </div>


                    <div class="row">
	                    <div class="form-actions floatRight">
	                        <input type="submit"  value="{{!ctrl.user.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid || myForm.$pristine">
	                        <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
	                    </div>
	                </div>
	            </form>
    	    </div>
		</div>	
    </div>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">List of Users </span></div>
		<div class="panel-body">
			<div class="table-responsive">
		        <table class="table table-hover">
		            <thead>
		            <tr>
		                <th>ID</th>
		                <th>NAME</th>
		                <th>E-MAIL</th>
		                <th>CITY/TOWN</th>
                        <th>ADDRESS</th>
                        <th>COUNTRY</th>
                        <th>LAST VIEW</th>
		                <th width="100"></th>
		                <th width="100"></th>
		            </tr>
		            </thead>
		            <tbody>
		            <tr ng-repeat="u in ctrl.getAllUsers()">
		                <td>{{u.id}}</td>
		                <td>{{u.name}}</td>
		                <td>{{u.eMail}}</td>
		                <td>{{u.townCity}}</td>
                        <td>{{u.addressLine1}}</td>
                        <td>{{u.country}}</td>
                        <td>{{u.dateLastView}}</td>
		                <td><button type="button" ng-click="ctrl.editUser(u.id)" class="btn btn-success custom-width">Edit</button></td>
		                <td><button type="button" ng-click="ctrl.removeUser(u.id)" class="btn btn-danger custom-width">Remove</button></td>
		            </tr>
		            </tbody>
		        </table>		
			</div>
		</div>
    </div>
</div>