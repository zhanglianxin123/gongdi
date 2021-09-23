import http from '../utils/http'

// export function getLoginAPI (url, params) {
//   return http.get(url, params)
// }

export function postLoginAPI (url, params) {
  return http.post(url, params)
}
