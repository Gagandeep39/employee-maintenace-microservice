export const environment = {
  production: true,
  url: 'http://192.168.99.100:9900',  // for docker
  login: '/employee-login-service/login',
  updateUser: '/employee-login-service/login/update',
  findUserById: '/employee-login-service/login/',
  changePassword: '/employee-login-service/login/change',

  addEmployee: '/employee-management-service/employees',
  fetchAllEmployee: '/employee-management-service/employees/search',
  searchByCategory: '/employee-management-service/employees/search/category',
  byName: '/employee-management-service/employees/search/name',
  byId: '/employee-management-service/employees/search/id/',

  employeeLeave: '/employee-leave-service/leaves/employee/',
  leaveBalance: '/employee-management-service/leaves/balance/',
  subEmployeeLeaves: '/employee-management-service/leaves/manager/',
  updateLeave: '/employee-management-service/leaves/',
  createLeave: '/employee-management-service/leaves/',

  grades: '/employee-validation-service/grades',
  departments: '/employee-validation-service/departments',
  managers: '/employee-validation-service/managers',
  roles: '/employee-validation-service/roles',
  validateUsername: '/employee-validation-service/username'
};