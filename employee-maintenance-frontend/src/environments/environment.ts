// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

export const environment = {
  production: false,
  url: 'http://192.168.56.1',
  login: ':9100/login',
  updateUser: ':9100/login/update',
  findUserById: ':9100/login/',
  changePassword: ':9100/login/change',
  addEmployee: ':9200/employees',
  fetchAllEmployee: ':9200/employees/search',
  searchByCategory: ':9200/employees/search/category',
  byName: ':9200/employees/search/name',
  byId: ':9200/employees/search/id/',
  employeeLeave: ':9300/leaves/employee/',
  leaveBalance: ':9300/leaves/balance/',
  subEmployeeLeaves: ':9300/leaves/manager/',
  updateLeave: ':9300/leaves/',
  createLeave: ':9300/leaves/',
  grades: ':9400/grades',
  departments: ':9400/departments',
  managers: ':9400/managers',
  roles: ':9400/roles',
  validateUsername: ':9400/username'
};

/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.
