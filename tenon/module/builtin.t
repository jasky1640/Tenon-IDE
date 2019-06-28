module _builtin_ (sysmodule, noview)

!{ built-in data types
record pos		! Positions (only X, Y and Z)
  num x;
  num y;
  num z;
end

record orient		! Orientation
  num q1;
  num q2;
  num q3;
  num q4;
end

record pose		! Coordinate transformations
  pos trans;
  orient rot;
end

alias num errnum;	! Error number
alias num intnum;	! Interrupt identity
!}

!{ built-in data objects
const num PI = 3.14159265358979323846   ! PI
!}
end

