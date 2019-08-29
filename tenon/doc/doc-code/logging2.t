! RUN: tenon -m base %s | FileCheck %s

module log_manager_test
  function void main()
    var string str = getLogDefaultHandler();
    twrite_string(str);

    var string str1 = "LOG_FILE";
    setLogDefaultHandler(str1);
    str = getLogDefaultHandler();
    twrite_string(str);

    str1 = "CONSOLE";
    setLogDefaultHandler(str1);
    str = getLogDefaultHandler();
    twrite_string(str);

    log_notset("Test the notset level log message.");
    log_debug("Test the debug level log message.");
    log_info("Test the info level log message.");
    log_warning("Test the warning level log message.");
    log_error("Test the error level log message.");
    log_critical("Test the critical level log message.");

    str = getLogDefaultMarker();
    twrite_string(str);

    log("NOTSET", "Test the notset level log message.");
    log("DEBUG", "Test the debug level log message.");
    log("INFO", "Test the info level log message.");
    log("WARNING", "Test the warning level log message.");
    log("ERROR", "Test the error level log message.");
    log("CRITICAL", "Test the critical level log message.");

    str1 = "TASK1";
    setLogDefaultMarker(str1);
    str = getLogDefaultMarker();
    twrite_string(str);

    log_marker("TASK1", "NOTSET", "Test the notset level log message.");
    log_marker("TASK1", "DEBUG", "Test the debug level log message.");
    log_marker("TASK1", "INFO", "Test the info level log message.");
    log_marker("TASK1", "WARNING", "Test the warning level log message.");
    log_marker("TASK1", "ERROR", "Test the error level log message.");
    log_marker("TASK1", "CRITICAL", "Test the critical level log message.");

    str = getLogDefaultLevel();
    twrite_string(str);

    str1 = "ERROR";
    setLogDefaultLevel(str1);
    str = getLogDefaultLevel();
    twrite_string(str);

    log_marker("TASK1", "NOTSET", "Test the notset level log message.");
    log_marker("TASK1", "DEBUG", "Test the debug level log message.");
    log_marker("TASK1", "INFO", "Test the info level log message.");
    log_marker("TASK1", "WARNING", "Test the warning level log message.");
    log_marker("TASK1", "ERROR", "Test the error level log message.");
    log_marker("TASK1", "CRITICAL", "Test the critical level log message.");
    log_fini();
  end
end

! CHECK: CONSOLE
! CHECK: LOG_FILE
! CHECK: CONSOLE
! CHECK: [SYSTEM] [INFO] Test the info level log message.
! CHECK: [SYSTEM] [WARNING] Test the warning level log message.
! CHECK: [SYSTEM] [ERROR] Test the error level log message.
! CHECK: [SYSTEM] [CRITICAL] Test the critical level log message.
! CHECK: SYSTEM
! CHECK: [SYSTEM] [INFO] Test the info level log message.
! CHECK: [SYSTEM] [WARNING] Test the warning level log message.
! CHECK: [SYSTEM] [ERROR] Test the error level log message.
! CHECK: [SYSTEM] [CRITICAL] Test the critical level log message.
! CHECK: TASK1
! CHECK: [TASK1] [INFO] Test the info level log message.
! CHECK: [TASK1] [WARNING] Test the warning level log message.
! CHECK: [TASK1] [ERROR] Test the error level log message.
! CHECK: [TASK1] [CRITICAL] Test the critical level log message.
! CHECK: INFO
! CHECK: ERROR
! CHECK: [TASK1] [ERROR] Test the error level log message.
! CHECK: [TASK1] [CRITICAL] Test the critical level log message.
