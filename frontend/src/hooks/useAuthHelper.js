function setSessionStorage(key, value) {
  sessionStorage.setItem(key, value);
}
function getSessionStorage(key) {
  return sessionStorage.getItem(key);
}

function isLoggedIn() {
  var isUserLoggedIn = getSessionStorage("isloggedIn");
  if (isUserLoggedIn != null) {
    return isUserLoggedIn;
  } else {
    return false;
  }
}

function clearStorage() {
  sessionStorage.removeItem("isloggedIn");
  sessionStorage.removeItem("email");
  sessionStorage.removeItem("token");
  sessionStorage.removeItem("isLogin");
  sessionStorage.removeItem("userName");
  // window.location.reload();
}

// function setAuthSetails(){
// }

function useAuthHelper() {
  return {
    setSessionStorage,
    getSessionStorage,
    isLoggedIn,
    clearStorage,
    
  };
}

export default useAuthHelper;
