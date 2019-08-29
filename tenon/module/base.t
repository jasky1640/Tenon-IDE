module _base_ (sysmodule, noview)

  !{ built-in types

  const num USINT = 1;   ! USINT
  const num UINT = 2;   ! UINT
  const num UDINT = 4;   ! UDINT
  const num ULINT = 8;   ! ULINT
  const num SINT = -1;   ! SINT
  const num INT = -2;   ! INT
  const num DINT = -4;   ! DINT
  const num LINT = -8;   ! LINT

  alias num aiotrigg;      ! Analog I/O trigger condition

  record accdata           ! Acceleration
    num acc;
    num ramp;
    num finepramp;
  end

  alias num btnres;        ! Push button result data
  alias num busstate;      ! State of I/O network
  alias num buttondata;    ! Push button data
  alias num byte;          ! Integer values 0 - 255
  opaque cameradev;        ! camera device

  record cameratarget      ! camera data
    string name;
    pose cframe;
    num val1;
    num val2;
    num val3;
    num val4;
    num val5;
    string string1;
    string string2;
    num type;
    string cameraname;
    num sceneid;
  end

  record capdata           ! CAP data
    bool start_fly;
    bool end_fly;
    bool first_instr;
    bool last_instr;
    num restart_dist;
    capspeeddata speed_data;
    flypointdata start_fly_point;
    flypointdata end_fly_point;
    supervtimeouts sup_timeouts;
    processtimes proc_times;
    restartblkdata block_at_restart;
  end

  record caplatrackdata    ! CAP Look_Ahead_Tracker track data
    num joint_no;
    num filter;
    num calibframe_no;
    num seamoffs_y;
    num seamoffs_z;
    num seamadpt_y;
    num seamadpt_z;
    num track_mode;
  end

  record capspeeddata      ! Speed data for CAP
    num fly_start;
    num start;
    num startspeed_time;
    num startmove_delay;
    num main;
    num fly_end;
  end

  record captrackdata      ! CAP track data
    string device;
    num max_corr;
    caplatrackdata la_trackdata;
  end

  record capweavedata      ! Weavedata for CAP
    bool active;
    num width;
    num shape;
    num type;
    num length;
    num cycle_time;
    num height;
    num dwell_left;
    num dwell_center;
    num swell_right;
    num dir;
    num tilt;
    num rot;
    num bias;
    bool ptrn_sync_on;
  end

  alias string cfgdomain;  ! Configuration domain
  opaque clock;            ! Time measurement

  record confdata          ! Robot configuration data
    num cf1;
    num cf4;
    num cf6;
    num cfx;
  end

  record confsupdata       ! robot configuration
    bool jsup;
    bool lsup;
    num ax1;
    num ax4;
    num ax6;
  end

  opaque corrdescr;        ! Correction generator descriptor
  opaque datapos;          ! Enclosing block for a data object
  alias num dionum;        ! Digital values(0 - 1)
  opaque dir;              ! File directory structure
  alias num egmframetype;  ! Defines frame types for EGM
  opaque egmident;         ! Identifies a specific EGM process

  record egm_minmax        ! Convergence criteria for EGM
    num min;
    num max;
  end

  alias num egmstate;      ! Defines the state for EGM
  alias num egmstopmode;   ! Defines stop modes for EGM
  alias num errdomain;     ! Error domain
  alias string errstr;     ! Error string
  alias num errtype;       ! Error type
  alias num event_type;    ! Event routine type
  alias num exec_level;    ! Execution level

  record extjoint          ! Position of external joints
    num eax_a;
    num eax_b;
    num eax_c;
    num eax_d;
    num eax_e;
    num eax_f;
  end

  record flypointdata      ! Data for flying start/end
    bool from_start;
    num process_dist;
    num distance;
  end

  alias num handler_type;  ! Type of execution handler
  alias num icondata;      ! Icon dispaly data
  alias num identno;       ! Identity for move instructions

  record inposdata
    num position;
    num speed;
    num mintime;
    num maxtime;
  end

  opaque iodev;            ! Serial channels and files
  alias num iounit_state;  ! State of I/O device

  record jointtarget       ! Joint position data
    robjoint robax;
    extjoint extax;
  end

  record listitem          ! List item data structure
    string image;
    string text;
  end

  record loaddata          ! Load data
    num mass;
    pos cog;
    orient aom;
    num ix;
    num iy;
    num iz;
  end

  alias num loadidnum;     ! Type of load identification
  opaque loadsession;      ! Program load session
  opaque mecunit;          ! Mechanical unit

  record motsetdata        ! Motion settings data
    veldata vel;
    accdata acc;
    singdata sing;
    confsupdata conf;
    num pathresol;
    bool motionsup;
    num tunevalue;
    bool acclim;
    num accmax;
    bool decellim;
    num decelmax;
    num cirpathreori;
    bool worldacclim;
    num worldaccmax;
    bool evtbufferact;
  end

  alias num opcalc;        ! Arithmetic Operator
  alias num opnum;         ! Comparison operator

  alias num paridnum;      ! Type of parameter identification
  alias num paridvalidnum; ! Result of ParldRobValid
  opaque pathrecid;        ! Path recorder identifier

  record processtimes      ! process times
    num pre;
    num post1;
    num post2;
  end

  record progdisp          ! Program displacement
    pose pdisp;
    extjoint eoffs;
  end

  opaque rawbytes;         ! Raw data

  record restartblkdata    ! blockfata for restart
    bool weave_start;
    bool motion_delay;
    bool pre_phase;
    bool startspeed_phase;
    bool post1_phase;
    bool post2_phase;
  end

  record restartdata       ! Restart data for trigg signals
    bool restartstop;
    bool stoponpath;
    dionum predo1val;
    dionum postdo1val;
    num prego1val;
    num postgo1val;
    num prego2val;
    num postgo2val;
    num prego3val;
    num postgo3val;
    num prego4val;
    num postgo4val;
    dionum preshadowval;
    dionum shadowflanks;
    dionum postshadowval;
  end

  record rmqheader         ! Message Queue Message header
    string datatype;
    num ndim;
    num dim1;
    num dim2;
    num dim3;
  end

  opaque rmqmessage;       ! Message Queue message
  opaque rmqslot;          ! Identity number of an RMQ client

  record robjoint          ! Joint position of robot axes
    num rax_1;
    num rax_2;
    num rax_3;
    num rax_4;
    num rax_5;
    num rax_6;
  end

  record robtarget         ! Position data
    pos trans;
    orient rot;
    confdata robconf;
    extjoint extax;
  end

  record sensor            ! External device descriptor
    num id;
    num serror;
  end

  alias num sensorstate;   ! Communication state of the device
  opaque shapedata;        ! World zone shape data;

  record singdata
    bool wrist;
    bool lockaxis4;
    bool arm;
    bool base;
  end

  alias num signalorigin;  ! Describes the I/O signal origin
  opaque signalai;         ! Digital and analog signals semi-value
  opaque signalao;         ! Digital and analog signals semi-value
  opaque signaldi;         ! Digital and analog signals semi-value
  opaque signaldo;         ! Digital and analog signals semi-value
  opaque signalgi;         ! Digital and analog signals semi-value
  opaque signalgo;         ! Digital and analog signals semi-value
  opaque socketdev;        ! Socket device
  alias num socketstatus;  ! Socket communication status

  record speeddata         ! Speed data
    num v_tcp;
    num v_ori;
    num v_leax;
    num v_reax;
  end

  record stoppointdata     ! Stop point data
    stoppoint stype;
    bool progsynch;
    inposdata inpos;
    num stoptime;
    num followtime;
    string signal;
    opnum relation;
    num checkvalue;
  end

  alias num stoppoint;     ! type of stop point
  alias string stringdig;  ! String with only digits

  record supervtimeouts    ! Handshake supervision time outs
    num pre_cond;
    num start_cond;
    num end_main_cond;
    num end_post1_cond;
    num end_post2_cond;
  end

  alias num symnum;        ! Symbolic number
  opaque syncident;        ! Identity for synchronization point
  opaque taskid;           ! Task identification

  record tasks             ! TENON program tasks
    string taskname;
  end

  alias num testsignal;    ! Test signal

  record tooldata          ! Tool data
    bool robhold;
    pose tframe;
    loaddata tload;
  end

  alias num tnum;          ! teach pendant window number
  opaque trapdata;         ! Interrupt data for current TRAP
  opaque triggdata;        ! Positioning events, trigg

  record triggios          ! Positioning events, trigg
    bool used;
    num distance;
    bool start;
    num equiplag;
    string signalname;
    num setvalue;
    num xxx;
  end

  alias num triggmode;     ! Trigg action mode

  record triggstrgo        ! Positioning events, trigg
    bool used;
    num distance;
    bool start;
    num equiplag;
    string signalname;
    stringdig setvalue;
    num xxx;
  end

  alias num tunetype;      ! Servo tune type
  alias num uishownum;     ! Instance ID for UIShow

  record veldata           ! Velocity
    num oride;
    num max;
  end

  record weavestartdata    ! weave start data
    bool active;
    num width;
    num dir;
    num cycle_time;
  end

  record wobjdata
    bool robhold;
    bool ufprog;
    string ufmec;
    pose uframe;
    pose oframe;
  end

  alias wztemporary wzstationary;     ! Stationary world zone data

  record wztemporary       ! Temporary world zone data
    num wz;
  end

  record zonedata          ! Zone data
    bool finep;
    num pzone_tcp;
    num pzone_ori;
    num pzone_eax;
    num zone_ori;
    num zone_leax;
    num zone_reax;
  end

  !}


  !{ opaque functions
  !Abs - Gets the absolute value
  opaque function num abs(num data) end

  !reduce the acceleration
  opaque function void accset(num acc, num ramp, num finepointramp = 100) end

  !ACos - Calculates the arc cosine value
  opaque function num acos(num data) end

  !ACosR - Calculates the arc cosine value
  opaque function num acosr(num data) end

  !activation of event buffer
  opaque function void acteventbuffer() end

  !activates a mechanical unit
  opaque function void actunit(mecunit MechUnit) end

  !adds a numeric value
  function void add(alias num reg1, num reg2)
    reg1 = reg1 + reg2;
  end

  !aliasio define I/O signal with alias name
  opaque function void aliasio(alias anytype from_signal,
                               alias anytype to_signal) end

  !resetting I/O signal with alias name
  opaque function void aliasioreset(alias anytype signal) end

  !ASin - Calculates the arc sine value
  opaque function num asin(num data) end

  !ASinR - Calculates the arc sine value
  opaque function num asinr(num data) end

  !ATan - Calculates the arc tangent value
  opaque function num atan(num data) end

  !ATanR - Calculates the arc tangent value
  opaque function num atanr(num data) end

  !ATan2 - Calculates the arc tangent2 value
  opaque function num atan2(num data1, num data2) end

  !ATan2R - Calculates the arc tangent2 value
  opaque function num atan2r(num data1, num data2) end

  !ByteToStr - Converts a byte to a string data (0-255 for dec, 00-FF for Hex,
  !  000-377 for Okt, 00000000-11111111 for Bin, One ASCII char for Char)
  opaque function string base_bytetostr(num bytedata, num oparg) end

  function string bytetostr(num bytedata, bool Dec = false, bool Hex = false, bool Okt = false,
                            bool Bin = false, bool Char = false)
    var string retdata;
    var num oparg = 10;
    if (Hex == true) then
      oparg = 16;
    elseif (Okt == true) then
      oparg = 8;
    elseif(Bin == true) then
      oparg = 2;
    elseif(Char == true) then
      oparg = 0;
    end

    retdata = base_bytetostr(bytedata, oparg);
    return retdata;
  end

  opaque function num base_fssize(string path, bool is_total, num retype) end

  function num fssize(string path, bool total = false, bool free = false,
                      bool kbyte = false, bool mbyte = false)
    var num ret;
    var num retype = 1;
    if kbyte == true then
      retype = 1024;
    elseif mbyte == true then
      retype = 1024 *1024;
    end

    ret = base_fssize(path, total, retype);
    return ret;
  end

  opaque function num base_gettime(num op) end

  function num gettime(num wday = 0, num hour = 0, num min = 0, num sec = 0)
    var num ret;
    var num op = 0;
    if hour == 1 then
      op = 1;
    elseif min == 1 then
      op = 2;
    elseif sec == 1 then
      op = 3;
    end
    ret = base_gettime(op);
    return ret;
  end

  !NOrient - Normalize orientation
  opaque function orient base_norient(alias orient ret, orient data) end

  function orient norient(orient rot)
    var orient ret;
    base_norient(ret, rot);
    return ret;
  end

  opaque function void base_orientzyx(alias orient rot, num z, num y, num x) end

  function orient orientzyx(num z, num y, num x)
    var orient ret;
    base_orientzyx(ret, z, y, x);
    return ret;
  end

  ! Save - Save a program module
  opaque function void base_save(string module_name, string file_path) end

  function void save(string module_name, string file_path = "")
    var num len = strlen(file_path);
    if len > 0 then
      base_save(module_name, file_path);
    else
      base_save(module_name, module_name + ".t");
    end
  end

  !StrToByte (String To Byte) is used to convert a string with a defined
  !  bytedata format into a byte data.
  opaque function num base_strtobyte(string constr, num oparg) end

  function num strtobyte(string constr, bool Hex = false, bool Okt = false,
                            bool Bin = false, bool Char = false)
    var num retdata;
    var num oparg = 10;
    if(Hex == true) then
      oparg = 16;
    elseif(Okt == true) then
      oparg = 8;
    elseif(Bin == true) then
      oparg = 2;
    elseif(Char == true) then
      oparg = 0;
    end

    retdata = base_strtobyte(constr, oparg);
    return retdata;
  end

  !TryInt - Test if data object is a valid interger
  opaque function num base_tryint(num data) end

  function num tryint(num data)
    var num value;
    value = base_tryint(data);
    return value;

  error
      raise;
  end

  !BitAnd is used to execute a logical bitwise AND
  opaque function num bitand(num data1, num data2) end

  ! Check if a specified bit in a byte data is set
  opaque function bool bitcheck(num bitdata, num bitpos) end

  !clear a specified bit in a byte or dnum data
  function void bitclear(alias num bitdata, num bitpos)
    var bool b;
    b = bitcheck(bitdata, bitpos);
    if b then
      bitdata = bitxor(bitdata, pow(2, bitpos - 1));
    end
  end

  !BitLSh (Bit Left Shift) is used to execute a logical bitwise LEFT SHIFT
  opaque function num bitlsh(num bitdata, num bitpos) end

  !BitNeg (Bit Negation) is used to execute a logical bitwise NEGATION
  opaque function num bitneg(num bitdata) end

  ! Logical bitwise OR - operation on byte data
  opaque function num bitor(num bitdata1, num bitdata2) end

  !BitiRSh (Bit Right Shift) is used to execute a logical bitwise RIGHT SHIFT
  opaque function num bitrsh(num bitdata, num bitpos) end

  !set a specified bit in a byte or dnum data
  function void bitset(alias num bitdata, num bitpos)
    var bool b;
    b = bitcheck(bitdata, bitpos);
    if not b then
      bitdata = bitor(bitdata, pow(2, bitpos - 1));
    end
  end

  ! Logical bitwise XOR - operation on byte data
  opaque function num bitxor(num bitdata1, num bitdata2) end

  !book a TENON system error number
  opaque function void bookerrno(errnum errorname) end

  !call a procedure by a variable
  opaque function void callbyvar(string name, num number) end

  !removes the collection data for the camera
  opaque function void camflush(cameradev camera) end

  !CamGetExposure - Get camera specific data
  opaque function void camgetexposure(cameradev camera, num exposuretime,
                                      num brightness, num contrast) end

  !get different named camera parameters
  opaque function void camgetparameter(cameradev camera, string parname,
                                       num numvar = 0, bool boolvar = void,
                                       string strvar = void) end

  !gets a camera target from the collection
  opaque function void camgetresult(cameradev camera, cameratarget camtarget,
                                    num sceneid = 0, num maxtime = 120) end

  !Get name of the loaded camera task
  opaque function string camgetloadedjob(cameradev camera) end

  !Get the name of the used camera
  opaque function string camgetname(cameradev camera) end

  !load a camera task into a camera
  opaque function void camloadjob(cameradev camera, string name,
                                  bool keeptargets = false, num maxtime = 120) end

 !Get number of available results
  opaque function void camnumberofresults(cameradev camera, num sceneid) end
                                  
  !order the camera to acquire an image
  opaque function void camreqimage(cameradev camera, num sceneid = 0,
                                   bool keeptargets = false,
                                   bool awaitcomplete = false) end

  !set camera specific data
  opaque function void camsetexposure(cameradev camera, num exposuretime = 0,
                                      num brightness = 0, num contrast = 0) end

  !set different named camera paramters
  opaque function void camsetparameter(cameradev camera, string parname,
                                       num numval = 0, bool boolval = false,
                                       string strval = void) end

  !orders the camera to go to program mode
  opaque function void camsetprogrammode(cameradev camera) end

  !CamSetRunMode - Orders the camera to run mode
  opaque function void camsetrunmode(cameradev camera) end

  !CamStartLoadJob - Start load of a camera task into a camera
  opaque function void camstartloadjob(cameradev camera, string name,
                                       bool keeptargets = false) end

  !CamWaitLoadJob – Wait until a camera task is loaded
  opaque function void camwaitloadjob(cameradev camera) end

  !CancelLoad - Cancel loading of a module
  opaque function void cancelload(loadsession loadno) end

  !CheckProgRef - Check program references
  opaque function void checkproref() end

  !CirPathMode - Tool reorientation during circle path
  opaque function void cirpathmode(bool pathframe = false, bool objectframe = false,
                                   bool cirpointori = false, bool wrist45 = false,
                                   bool wrist46 = false, bool wrist56 = false) end

  !Clear - Clears the value
  function void clear(alias num reg1)
    reg1 = 0;
  end

  !ClearIOBuff - Clear input buffer of a serial channel
  opaque function void cleariobuff(iodev iodevice) end

  !ClearPath - Clear current path
  opaque function void clearpath() end

  !ClearRawBytes - Clear the contents of rawbytes data
  opaque function void clearrawbytes(rawbytes rawdata, num FromIndex = 1) end

  !ClkReset - Resets a clock used for timing
  opaque function void clkreset(clock Clock) end

  !ClkStart - Starts a clock used for timing
  opaque function void clkstart(clock Clock) end

  !ClkStop - Stops a clock used for timing
  opaque function void clkstop(clock Clock) end

  !Close - Closes a file or serial channel
  opaque function void close(alias iodev iodevice) end

  !CloseDir - Close a directory
  opaque function void closedir(dir dev) end

  !CDate - Reads the current date as a string
  opaque function string cdate() end

  !ConfJ - Controls the configuration during joint movement
  opaque function void confj(bool on) end

  !ConfL - Monitors the configuration during linear movement
  opaque function void confl(bool on) end

  !CopyFile - Copy a file
  opaque function bool copyfile(string oldfile,string newfile) end

  !CopyRawbytes
  opaque function bool copyrawbytes(alias rawbytes fromRawdata, num fromIndex,
                                    alias rawbytes toRawdata, num toIndex,
                                    num noOfBytes) end

  !corrclear - Removes all correction generators
  opaque function void corrclear() end

  !CorrCon - Connects to a correction generator
  opaque function void corrcon(corrdescr descr) end
  
  !CorrDiscon -Disconnects from a correction generator
  opaque function void corrdiscon(corrdescr descr) end
  
  !CorrWrite - Writes to a correction generator 
  opaque function void corrwrite(corrdescr descr, pos data) end

  !Cos - Calculates the cosine value
  opaque function num cos(num data) end

  !CosR (Cosine) is used to calculate the cosine value from an radian value
  opaque function num cosr(num data) end
  
  !CSpeedOverride - Reads the current override speed
  opaque function num cspeedoverride(bool ctask) end

  !CTime - Reads the current time as a string
  opaque function string ctime() end

  !Decr is used to subtract 1 from a numeric variable or persistent.
  function void decr(alias num reg1)
    reg1 = reg1 - 1;
  end

  !DeactEventBuffer - Deactivation of event buffer
  opaque function void deacteventbuffer() end

  !DeactUnit - Deactivates a mechanical unit
  opaque function void deactunit(mecunit mecu) end

  !DecToHex - Convert from decimal to hexadecimal
  opaque function string dectohex(string str) end

  !Dim - Gets the specified dimension of an array
  opaque function num dim(anytype array{}, num dim) end

  !Distance - Distance between two points
  opaque function num distance(pos point1, pos point2) end

  !DotProd - Dot product of two pos vectors
  opaque function num dotprod(pos vector1, pos vector2) end

  !DropSensor - Drop object on sensor
  opaque function void dropsensor(mecunit mecu) end

  !DropWObj - Drop work object on conveyor
  opaque function void dropwobj(wobjdata data) end

  !Deactivates an offset for additional axes
  opaque function void eoffsoff() end

  !Activates an offset for additional axes using known values
  opaque function void eoffsset(extjoint eaxoffs) end

  !Exp - Calculates the exponential value
  opaque function num exp(num data) end

  !FileSize - Retrieve the size of a file
  opaque function num filesize(string path) end

  opaque function num filetime(string path, string file_type) end

  opaque function void freedatasearch(alias datapos block) end

  !FreeRawBytes - Free rawbytes data
  opaque function void freerawbytes(rawbytes rawdata) end

  !FricIdInit - Initiate friction identification
  opaque function void fricidinit() end

  opaque function string getLogDefaultHandler() end

  opaque function string getLogDefaultLevel() end

  opaque function string getLogDefaultMarker() end

  !GetMecUnitName - Get the name of the mechanical unit
  opaque function string getmecunitname(mecunit mec) end

  !GetMotorTorque - Reads the current motor torque
  opaque function num getmotortorque(mecunit mec, num axisno) end

  !GetSignalOrigin - Get information about the origin of an I/O signal
  opaque function signalorigin getsignalorigin(signaldo signal, string name) end

  opaque function string getsysinfo (string str) end

  !GripLoad - Define the playload for a robot
  opaque function void gripload(loaddata data) end

  !HexToDec - Convert from hexadecimal to decimal
  opaque function string hextodec(string str) end

  !IndCMove - Independent continuous movement
  opaque function void indcmove(mecunit mec, num axis, num speed, num ramp = 0)
  end

  !IndDMove - Independent delta position movement
  opaque function void inddmove(mecunit mec, num axis, num delta, num speed,
                                num ramp = 0) end

  !IndInpos - Independent axis in position status
  opaque function void indinpos(mecunit mecunit, num axis) end

  !IndSpeed - Independent speed status
  opaque function void indspeed(mecunit mecunit, num axis, 
                                bool inspeed, bool zerospeed) end

  !InitRawBytes - Init rawbytes data
  opaque function void initrawbytes(alias rawbytes rawdata) end

  ! Break program execution.
  opaque function void insbreak() end

  !IOBusStart - Start of I/O network
  opaque function void iobusstart(string busname) end

  !IOBusState - Get current state of I/O network
  opaque function void iobusstate(string busname, busstate state, bool phys,
                                  bool logic) end

  !IODisable - Deactivate an I/O device
  opaque function void iodisable(string busname, num maxtime) end

  !IOEnable - Activate an I/O device
  opaque function void ioenable(string busname, num maxtime) end

  !IOUnitState - Get current state of I/O device
  opaque function void iounitstate(string unitname, bool phys, bool logic) end

  opaque function bool isfile(string path, string file_type) end

  !ISignalAI - Interrupts from analog input signal
  opaque function void isignalai(num interrupt_s, signalai signal,
                                 num cond, num highval, num lowval, num deltaval,
                                 num data_s, num interrupt_num) end

  !IsLeadThrough - Check lead-through status
  opaque function bool isleadthrough(mecunit mechunit, bool active, bool set) end

  !IsMechUnitActive - Is mechanical unit active
  opaque function bool ismechunitactive(mecunit mechunit) end

  !IsPers - Is persistent
  opaque function bool ispers(alias anytype DatObj) end

  !IsStopMoveAct - Is stop move flags active
  opaque function bool isstopmoveact(bool frommovetask, bool fromnonmovetask) end

  !IsSyncMoveOn - Test if in synchronized movement model
  opaque function bool issyncmoveon() end

  !IsVar - Is variable
  opaque function bool isvar(alias anytype DatObj) end

  ! Load - Load a program module during execution
  opaque function void load(string file_path) end

  opaque function void log_init() end
  opaque function void log_fini() end
  opaque function void log_marker(string marker, string level, string message) end

  function void log(string level, string message)
    log_marker("SYSTEM", level, message);
    return;
  error
    raise;
  end

  function void log_critical(string message)
    log("CRITICAL", message);
  end

  function void log_debug(string message)
    log("DEBUG", message);
  end

  function void log_error(string message)
    log("ERROR", message);
  end

  function void log_info(string message)
    log("INFO", message);
  end

  function void log_notset(string message)
    log("NOTSET", message);
  end

  function void log_warning(string message)
    log("WARNING", message);
  end

  !MakeDir - Create a new directory
  opaque function void makedir(string path) end

  !MaxRobSpeed - Maximum robot speed
  opaque function num maxrobspeed() end

  !MechUnitLoad - Defines a payload for a mechanical unit
  opaque function void mechunitload(mecunit mechunit, num axisno,
                                    loaddata loadn) end

  opaque function bool modexist(string modname) end

  !MToolRotCalib - Calibration of rotation for moving tool
  opaque function void mtoolrotcalib(jointtarget reftip, jointtarget zpos,
                                     jointtarget xpos, tooldata tool) end

  !MToolTcpCalib - Calibration of Tcp for moving tool
  opaque function void mtooltcpcalib(robtarget pos1, robtarget pos2,
                                     robtarget pos3, robtarget pos4,
                                     tooldata tool, num maxerr, num meanerr) end

  !NonMotionMode - Read the Non-Motion execution mode
  opaque function bool nonmotionmode(num maint) end

  !NumToStr - Converts numeric value to string
  opaque function string numtostr(num val, num dec, num exp = 0) end

  !OpMode - Read the operating mode
  opaque function num opmode() end

  opaque function void open(string filename, alias iodev iodevice, string mode)
  end

  !OpenDir - Open a directory
  opaque function void opendir(alias dir Dev, string path) end

  !PackDNHeader - Pack DeviceNet Header into rawbytes data
  opaque function void packdnheader(string Service, string Path,
                                    rawbytes rawdata) end

  opaque function void packrawbytes_ascii(string Value, rawbytes rawdata,
                                          num StartIndex) end

  opaque function void packrawbytes_float(num Value, rawbytes rawdata,
                                          num StartIndex, bool Network) end

  !PackRawBytes - Pack data into rawbytes data
  opaque function void packrawbytes_hex(num Value, rawbytes rawdata,
                                        num StartIndex) end

  opaque function void packrawbytes_int(num Value, rawbytes rawdata,
                                        num StartIndex, bool Network,
                                        num IntTypes) end

  function void packrawbytes(rawbytes rawdata,  num Value=0, string sValue="",
                             bool Network = false, num StartIndex = 1,
                             bool Hex1 = false,  num Intx = 0, bool Float4 = false,
                             num ASCII = 0)
    var num inttypes = 0;
    var bool netflag = false;
    if(Hex1 == true)then
      packrawbytes_hex(Value,rawdata,StartIndex);
    elseif (Intx == 1) then
      inttypes = Intx;
      netflag = Network;
      packrawbytes_int(Value, rawdata, StartIndex, netflag, inttypes);
    elseif (Float4 == true) then
      netflag = Network;
      packrawbytes_float(Value, rawdata, StartIndex, netflag);
    elseif (ASCII == 1) then
      packrawbytes_ascii(sValue,rawdata,StartIndex);
    end
  end

  !PathAccLim - Reduce TCP acceleration along the path
  opaque function void pathacclim(bool acclim, num accmax,
                                  bool decellim, num decelmax) end

  !PathLevel - Get current path level
  opaque function num pathlevel() end

  !PathRecMoveBwd - Move path recorder backwards
  opaque function void pathrecmovebwd(pathrecid pathrecid,
                                      pos tooloffs, speeddata speed) end

  !PathRecMoveFwd - Move path recorder forward
  opaque function void pathrecmovefwd(pathrecid pathrecid,
                                      pos tooloffs, speeddata speed) end

  !PathRecStart - Start the path recorder
  opaque function void pathrecstart(pathrecid pathrecid) end

  !PathRecStop - Stop the path recorder
  opaque function void pathrecstop(bool clear) end

  !PathRecValidBwd - Is there a valid backward path recorded
  opaque function bool pathrecvalidbwd(pathrecid pathrecid) end
  
  !PathRecValidFwd - Is there a valid forward path recorded 
  opaque function bool pathrecvalidfwd(pathrecid pathrecid) end

  !PathResol - Override path resolution
  opaque function void pathresol(num pathsampletime) end

  !PDispOff - Deactivates program displacement
  opaque function void pdispoff() end

  !PDispOn - Activates program displacement
  opaque function void pdispon(bool rot, robtarget exep, robtarget progpoint,
                              tooldata tool, wobjdata wobj) end

  !PDispSet - Activates program displacement using known frame
  opaque function void pdispset(pose dispframe) end

  ! PoseInv - Inverts pose data, the return pos is the inverse pos.
  ! For orient, the vector is the same, the angle is 2*PI - A;
  function pose poseinv(pose p1)
    var pose ret = [[0, 0, 0], [1, 0, 0, 0]];
    var pos tran1;
    ret.trans.x = 0 - p1.trans.x;
    ret.trans.y = 0 - p1.trans.y;
    ret.trans.z = 0 - p1.trans.z;

    ret.rot.q1 = 0 - p1.rot.q1;
    ret.rot.q2 = p1.rot.q2;
    ret.rot.q3 = p1.rot.q3;
    ret.rot.q4 = p1.rot.q4;

    return ret;
  end

  !PoseMult - Multiplies pose data
  function pose posemult(pose p1, pose p2)
    var pose ret;
    ret.trans = p1.trans + p2.trans;
    ret.rot = p1.rot * p2.rot;
    return ret;
  end

  !PoseVect - Applies a transformation to a vector
  function pos posevect(pose p, pos p1)
    var pos ret;
    ret = p.trans + p1;
    return ret;
  end

  !Pow - Calculates the power of a value
  opaque function num pow(num data1, num data2) end


  opaque function void printdataval(alias datapos block,
                                    string varname = "void") end

  !PrxActivAndStoreRecord - Activate and store the recorded profile data
  opaque function void prxactivandstorerecord(mecunit mechunit, num delay,
                                              string filename) end

  !PrxActivRecord - Activate the recorded profile data
  opaque function void prxactivrecord(mecunit mechunit, num delay) end

  !PrxDeactRecord - Deactivate a record
  opaque function void prxdeactrecord(mecunit mechunit) end

  !PrxGetMaxRecordpos - Get the maximum sensor position
  opaque function void prxgetmaxrecordpos(mecunit mechunit) end

  !PrxResetPos - Reset the zero position of the sensor
  opaque function void prxresetpos(mecunit mechunit) end

  !PrxResetRecords - Reset and deactivate all records 
  opaque function void prxresetrecords(mecunit mechunit) end

  !PrxSetPosOffset - Set a reference position for the sensor
  opaque function void prxsetposoffset(mecunit mechunit, num reference) end
  
  !PrxSetRecordSampleTime - Set the sample time for recording a profile 
  opaque function void prxsetrecordsampletime(mecunit mechunit, num sampletime) end

  !PrxSetSyncalarm - Set sync alarm behavior 
  opaque function void prxsetsyncalarm(mecunit mechunit, num time, bool nopulse) end

  !PrxStopRecord - Stop recording a profile
  opaque function void prxstoprecord(mecunit mechunit) end

  !PrxStoreRecord - Store the recorded profile data
  opaque function void prxstorerecord(mecunit mechunit, num delay, string filename) end
  
  !PrxUseFileRecord - Use the recorded profile data
  opaque function void prxusefilerecord(mecunit mechunit, num delay, string filename) end

  !PulseDO - Generates a pulse on a digital output signal
  opaque function void pulsedo(bool high, num plength, signaldo signal) end

  !RawBytesLen - Get the length of rawbytes data
  opaque function num rawbyteslen(rawbytes rawdata) end
  
  !ReadAnyBin - Read data from a binary serial channel or file
  opaque function void readanybin(iodev iodevice, anytype data, num time) end

  !ReadBin - Reads a byte from a file or serial channel
  opaque function num readbin(iodev iodevice, num numb) end

  !ReadBlock - read a block of data from device
  opaque function void readblock(string device, num blockno, 
                                 string filename, string taskname) end
               
  !ReadDir - Read next entry in a directory
  opaque function bool readdir(dir Dev, alias string filepath) end

  !ReadNum - Read a number from a file or serial channel
  opaque function num readnum(iodev iodevice, string delim = "", num time = 0)
  end

  !ReadRawBytes - Read rawbytes data
  opaque function void readrawbytes(iodev iodevice, rawbytes rawdata, num time)
  end

  !ReadStr - Read a string from a file or serial channel
  opaque function string readstr(iodev iodevice,  string delim = "",
                                 bool removecr = false,
                                 bool discardheads = false, num time = 0)
  end

  !ReadStrBin - Read a string from a binary serial channel or file
  opaque function string readstrbin(iodev iodevice, num noofchars, num time = 0)
  end

  !ReadVar - Read variable from a device
  opaque function num readvar(string device, num varno, string taskname = "")
  end

  !RemoveDir - Delete a directory
  opaque function void removedir(string path) end

  !RemoveFile - Delete a file
  opaque function void removefile(string filepath) end

  !RenameFile - Rename a file
  opaque function void renamefile(string oldfile,string newfile) end

  !Reset - Resets a digital output signal 
  opaque function void reset(signaldo signal) end

  !RestToPath - Restores the path after an interrupt
  opaque function void restopath() end

  !Round - Round a numeric value
  opaque function num round(num val, num Dec = 0) end

  !RunMode - Read the running mode
  opaque function num runmode(num data) end

  !SenDevice - Connect to a sensor device
  opaque function void sendevice(string device) end

  !Set - Set a digital output signal
  opaque function void set(signaldo signal) end

  !SetAO - Changes the value of an analog output signal
  opaque function void setao(signalao signal, num value) end

  !SetDO - Changes the value of a digital output signal
  opaque function void setdo(signaldo signal, num value, num sdelay = 0,
                             bool sync = false) end

  !SetGO - Changes the value of a group of digital output signals
  opaque function void setgo(signalgo signal, num value, num sdelay = 0) end

  opaque function void setdatasearch(string type, alias datapos block,
                                     num level = 0, string inmod = void,
                                     string varname = void) end

  opaque function void setdataval(anytype val, alias datapos block) end

  !SetLeadThrough - Activate and deactivate lead-through
  opaque function void setleadthrough(bool onoff, bool nostopmove,
                                      bool noclearpath) end

  opaque function void setLogDefaultHandler(string handler) end

  opaque function void setLogDefaultLevel(string level) end

  opaque function void setLogDefaultMarker(string marker) end

  !Send SIGNUM to all tasks.
  opaque function void signal(num signum) end

  !Trigger CONNECT_VAL which is connected with trap (signal handler) when
  !   received SIGNUM.
  opaque function void sigaction(num signum, alias num connect_val) end

  !Sin - Calculates the sine value
  opaque function num sin(num data) end

  !SinR (Sine) is used to calculate the sine value from an radian value
  opaque function num sinr(num data) end

  !SocketAccept - Accept an incoming connection
  opaque function void socketaccept(socketdev Socket, alias socketdev ClientSocket) end

  !SocketBind - Bind a socket to my IP-address and port
  opaque function void socketbind(socketdev Socket, string LocalAddress, num LocalPort) end

  !SocketClose - Close a socket
  opaque function void socketclose(socketdev Socket) end

  !SocketConnect - Connect to a remote computer
  opaque function void socketconnect(socketdev Socket, string Address, num port,
                                     num Time = 60) end

  !SocketCreateTcp - Create a new tcp socket
  opaque function void socketcreatetcp(alias socketdev Socket) end

  !SocketCreateUdp - Create a new udp socket
  opaque function void socketcreateudp(alias socketdev Socket) end

  !SocketCreate - Create a new socket
  function void socketcreate(alias socketdev Socket, bool TCP = false, bool UDP = false)
    if (TCP == true) then
      socketcreatetcp(Socket);
    elseif (UDP == true) then
      socketcreateudp(Socket);
    end
  end

  !SocketGetStatus - Get current socket status
  opaque function num socketgetstatus(socketdev Socket) end

  !SocketListen - Listen for incoming connections
  opaque function void socketlisten(socketdev Socket) end

  !SocketReceive - Receive data from remote computer
  opaque function void socketreceive(socketdev Socket, alias string data) end

  !SocketReceiveFrom - Receive data from remote computer
  opaque function void socketreceivefrom(socketdev Socket, string ip, num port,
                                         string data) end

  !SocketSend - Send data to remote computer
  opaque function void socketsend(socketdev Socket, string data) end

  !SocketSendTo - Send data to remote computer
  opaque function void socketsendto(socketdev Socket, string ip, num port,
                                    string data) end

  !Sqrt - Calculates the square root value
  opaque function num sqrt(num data) end

  opaque function num start_interrupt(num interrupt_num) end

  function string strdigcalc(string str1, string opkind, string str2)
    var num val;
    var string ret;
    var num val1 = strtonum(str1);
    var num val2 = strtonum(str2);
    if opkind == "SUB" then
      val = val1 - val2;
    elseif opkind == "ADD" then
      val = val1 + val2;
    elseif opkind == "MULT" then
      val = val1 * val2;
    elseif opkind == "DIV" then
      val = val1 div val2;
    else
      val = val1 mod val2;
    end
    ret = numtostr(val, 0);
    return ret;
  end

  function bool strdigcmp(string str1, string relation, string str2)
    var num val1 = strtonum(str1);
    var num val2 = strtonum(str2);
    if relation == "LT" then
      return val1 < val2;
    elseif relation == "LTEQ" then
      return val1 <= val2;
    elseif relation == "EQ" then
      return val1 == val2;
    elseif relation == "NOTEQ" then
      return val1 <> val2;
    elseif relation == "GTEQ" then
      return val1 >= val2;
    else
      return val1 > val2;
    end
  end

  ! strfind searches in STR, starting at POS, for a character that belongs to
  ! SET. When NotInSet is true, searches for a character not in the set.
  opaque function num strfind(string str, num pos, string set, num NotInSet = 0)
  end

  ! strlen return length of STR.
  opaque function num strlen(string str) end

  ! strmap creates a copy of a STR, and maps all characters in FROMMAP to TOMAP.
  opaque function string strmap(string str, string frommap, string tomap) end

  ! strmatch searches STR using PATTERN, starting at OFF. It returns the offset
  ! of the first substring.
  opaque function num strmatch(string str, num off, string patten) end

  ! strmemb checks whether SRC[INDEX] belongs to char set SEARCH.
  opaque function bool strmemb(string str, num index, string search) end

  ! strorder compares STR and STR1, returns a boolean indicating whether the
  ! two are in order according to a specified character ordering sequence ORDER.
  opaque function bool strorder(string str, string str1, string order) end

  ! strpart finds part of STR from PART_OFF and with PART_LEN.
  opaque function string strpart(string str, num part_off, num part_len) end

  opaque function num strtonum(string str) end

  opaque function bool strtoval(string str, alias anytype data) end

  !Tan - Calculates the tangent value
  opaque function num tan(num data) end

  !TanR (Tangent) is used to calculate the tangent value from an radian value
  opaque function num tanr(num data) end

  !Trunc - Truncates a numeric value
  opaque function num trunc(num val, num dec = 0) end

  !Type returns DATA type in string
  opaque function string type(anytype data) end

  ! TWrite - Writes on the teach pendant
  opaque function void twrite(string format, num ndata = 0,
                              bool bdata = false, pos pdata = [0, 0, 0],
                              orient odata = [0, 0, 0, 0]) end

  function void twrite_bool(bool data)
    twrite("%b", bdata = data);
  end

  function void twrite_num(num data)
    twrite("%n", ndata = data);
  end

  function void twrite_orient(orient data)
    twrite("%o", odata = data);
  end

  function void twrite_pos(pos data)
    twrite("%p", pdata = data);
  end

  function void twrite_string(string data)
    twrite(data);
  end

  opaque function void unpackrawbytes_ascii(alias string Value, rawbytes rawdata,
                                           num StartIndex, num StrLen) end

  opaque function void unpackrawbytes_float(alias num Value, rawbytes rawdata,
                                            num StartIndex, bool Network) end

  opaque function void unpackrawbytes_hex(alias num Value, rawbytes rawdata,
                                          num StartIndex) end

  opaque function void unpackrawbytes_int(alias num Value, rawbytes rawdata,
                                          num StartIndex, bool Network,
                                          num IntTypes) end

  function void unpackrawbytes(rawbytes rawdata, alias num Value,
                               bool Network = false, num StartIndex = 1,
                               bool Hex1 = false,  num Intx = 0, bool Float4 = false)
    var num inttypes = 0;
    var bool netflag = false;
    var num data;
    if(Hex1 == true)then
      unpackrawbytes_hex(Value, rawdata, StartIndex);
    elseif (Intx == 1) then
      inttypes = Intx;
      netflag = Network;
      unpackrawbytes_int(Value, rawdata, StartIndex, netflag, inttypes);
    elseif (Float4 == true) then
      netflag = Network;
      unpackrawbytes_float(Value, rawdata, StartIndex, netflag);
    end
  end

  function void unpackrawbytes_string(rawbytes rawdata, alias string Value,
                                      num StartIndex = 1, num ASCII = 0)
    var num strlen = 0;
    strlen = ASCII;
    unpackrawbytes_ascii(Value, rawdata, StartIndex, strlen);
  end

  opaque function string valtostr(anytype data) end

  opaque function num vectmagn(pos vect) end

  opaque function void waittime(num time) end

  opaque function void writeanybin(alias iodev iodevice, anytype data) end

  !WriteBin - Writes to a binary serial channel
  function void writebin(iodev iodevice, num buffer{*}, num nchar)
    for i from 1 to nchar do
      writeanybin(iodevice, buffer{i});
    end
  end

  function void writeerror(string str)
    log_error(str);
  end

  function void writeinfo(string str)
    log_info(str);
  end

  !WriteRawBytes - Write rawbytes data
  opaque function void writerawbytes(iodev iodevice, rawbytes rawdata,
                                     num NoOfBytes) end

  !WriteStrBin - Writes a string to a binary serial channel
  function void writestrbin(iodev iodevice, string str)
    writeanybin(iodevice, str);
  end

  function void writewarn(string str)
    log_warning(str);
  end
  !}

end
