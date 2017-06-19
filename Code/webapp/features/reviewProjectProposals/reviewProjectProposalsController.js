(function () {
    'use strict';

    angular
        .module('reviewProjectProposals', ['ProjectProposalService', 'vip-projects'])
        .controller('reviewProjectController', function ($window, $state, $scope, reviewPPS, ToDoService, User, ProjectService, LocationService, adminService)

        {
        var vm = this;
        vm.projects;
        vm.modified_projects;
        vm.logs;
        vm.AcceptProject = AcceptProject;
        vm.RejectProject = RejectProject;
        vm.UndoProject = UndoProject;
        vm.DeleteLog = deletelog;


            vm.adminEmail;
            adminService.getAdminSettings().then(function (data)
            {
                var adminData;
                adminData = data;
                console.log(adminData);
                console.log(adminData.current_email);
                vm.adminEmail = adminData.current_email;
            });

            init();

        function init() {
            loadData();
            loadLogs();
        }

        function loadData() {
            reviewPPS.loadProjects().then(function (data) {
                vm.projects = data;
            });
        }

        // User Story #1207
        function AcceptProject(projectid, owner, owner_name, title, email, rank, description, image, term, firstSemester, maxStudents, proposedDate) {

            reviewPPS.AcceptProjects(projectid).then(function (data) {
                $scope.result = "Project Approved";
                var todo = {
                    owner: rank,
                    owner_id: owner,
                    todo: "Dear proposer of project, the project titled: " + title + " has been approved by the PI. Link To Project: \n" + LocationService.vipWebUrls.projectDetailed + "/" + projectid,
                    type: "project",
                    link: "/#/to-do"
                };
                ToDoService.createTodo(todo).then(function (success) {

                }, function (error) {

                });
                var email_msg =
                    {
                        recipient: email,
                        text: "Dear proposer of project, the project titled: " + title + " has been approved by the PI. Link To Project: \n" + LocationService.vipWebUrls.projectDetailed + "/" + projectid,
                        subject: "Project Approved",
                        recipient2: vm.adminEmail,
                        text2: "",
                        subject2: ""
                    };
                User.nodeEmail(email_msg);

                success_msg();

                console.log(owner_name);
                // User Story #1207
                var log = {
                    projectid: projectid,
                    student: owner,
                    firstName: owner_name,
                    lastName: owner_name,
                    fullName: owner_name,
                    studentemail: email,
                    selectProject: title,
                    description: description,
                    image: image,
                    term: term,
                    minStudents: firstSemester,
                    maxStudents: maxStudents,
                    action: "Approved",
                    type: "project",
                    proposedDate: proposedDate
                };
                reviewPPS.createLog(log).then(function (success) {

                }, function (error) {
                });


            });
        }

        // User Story #1207
        function RejectProject(projectid, owner, owner_name, title, email, rank, description, image, term, firstSemester, maxStudents, proposedDate) {
            reviewPPS.RejectProjects(projectid).then(function (data) {
                $scope.result = "Project Rejected";
                var todo = {
                    owner: rank,
                    owner_id: owner,
                    todo: "Dear proposer of project, the project titled: " + title + " has been rejected by the PI. Please contact the PI for the specific reason why the project didn't meet the criteria for acceptance.",
                    type: "project",
                    link: "/#/to-do"
                };
                ToDoService.createTodo(todo).then(function (success) {

                }, function (error) {

                });
                var email_msg =
                    {
                        recipient: email,
                        text: "Dear proposer of project, the project titled: " + title + " has been rejected by the PI. Please contact the PI for the specific reason why the project didn't meet the criteria for acceptance.",
                        subject: "Project Rejected",
                        recipient2: vm.adminEmail,
                        text2: "",
                        subject2: ""
                    };
                User.nodeEmail(email_msg);

                console.log(owner_name);
                var log = {
                    projectid: projectid,
                    student: owner,
                    firstName: owner_name,
                    lastName: owner_name,
                    fullName: owner_name,
                    studentemail: email,
                    selectProject: title,
                    description: description,
                    image: image,
                    term: term,
                    minStudents: firstSemester,
                    maxStudents: maxStudents,
                    action: "Rejected",
                    type: "project",
                    proposedDate: proposedDate
                };
                reviewPPS.createLog(log).then(function (success) {

                }, function (error) {
                });
            });

            reject_msg();

        }

        // User Story #1207
        function UndoProject(projectid, logid, action, ownerid, owner_name, title, email, desc, image, term, minStud, maxStud, proposedDate) {
            if (action == "Rejected") {
                //Call service to create a project:
                var proj = {
                    owner: ownerid,
                    title: title,
                    owner_email: email,
                    owner_rank: "",
                    owner_name: owner_name,
                    firstSemester: minStud,
                    maxStudents: maxStud,
                    description: desc,
                    status: "pending",
                    image: image,
                    term: term,
                    proposedDate: proposedDate
                };
                ProjectService.createProject(proj).then(function (success) {
                }, function (error) {
                });
                //Call service to delete in log
                reviewPPS.UndoLog(logid).then(function (success) {
                }, function (error) {
                });
                undo_msg();
            }
            if (action == "Approved") {
                //Call service to check members, if no members then they can undo, else do not let them undo the project
                ProjectService.getProject(projectid).then(function (data) {
                    var thisProj = data;
                    //console.log(thisProj);
                    if (thisProj.members.length > 0) {
                        undoerror_msg();
                    }
                    else {
                        //Call service to create a project:
                        var proj = {
                            owner: ownerid,
                            title: title,
                            owner_email: email,
                            owner_rank: "",
                            owner_name: owner_name,
                            firstSemester: minStud,
                            maxStudents: maxStud,
                            description: desc,
                            status: "pending",
                            image: image,
                            term: term,
                            proposedDate: proposedDate
                        };
                        reviewPPS.UndoActiveProject(projectid, proj).then(function (success) {
                                console.log("WORKS!");
                            }
                            , function (error) {
                                console.log(error);
                            });
                        //Call service to delete in log
                        reviewPPS.UndoLog(logid).then(function (success) {
                        }, function (error) {
                        });

                    }
                }, function (error) {
                });
                undo_msg();

            }
        }

        function deletelog(log) {
            //Call service to delete in log
            reviewPPS.UndoLog(log._id).then(function (success) {
                logdelete_msg()
            }, function (error) {
            });
        }

        function logdelete_msg() {
            swal({
                    title: "Log Deleted",
                    text: "This log has been successfully deleted",
                    type: "info",
                    confirmButtonText: "Okay",
                    allowOutsideClick: true,
                    timer: 7000,
                }, function () {
                    $window.location.reload();
                }
            );
        };


        function success_msg() {
            swal({
                    title: "Accepted",
                    text: "Project has been accepted and user notified",
                    type: "info",
                    confirmButtonText: "Continue",
                    allowOutsideClick: true,
                    timer: 7000,
                }, function () {
                    $window.location.reload();
                }
            );
        };

        function undoerror_msg() {
            swal({
                    title: "Undo Unsuccessful",
                    text: "This project must have its members removed first.",
                    type: "error",
                    confirmButtonText: "Okay",
                    allowOutsideClick: true,
                    timer: 7000,
                }, function () {

                }
            );
        };

        function undo_msg() {
            swal({
                    title: "Undo Successful",
                    text: "This projects status now requires approval",
                    type: "info",
                    confirmButtonText: "Okay",
                    allowOutsideClick: true,
                    timer: 7000,
                }, function () {
                    $window.location.reload();
                }
            );
        };


        function reject_msg() {
            swal({
                    title: "Project Rejected",
                    text: "Project has been denied and user notified",
                    type: "warning",
                    confirmButtonText: "Continue",
                    allowOutsideClick: true,
                    timer: 7000,
                }, function () {
                    $window.location.reload();
                }
            );
        };

        function loadLogs() {
            reviewPPS.loadLog("project").then(function (data) {
                vm.logs = data;
            });
        }


    });
}());