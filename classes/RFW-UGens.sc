AverageOutput : UGen {
  *ar {
    arg in, trig=0.0, mul=1.0, add=0.0;
    ^this.multiNew('audio', in, trig).madd(mul, add);
  }
  
  *kr {
    arg in, trig=0.0, mul=1.0, add=0.0;
    ^this.multiNew('control', in, trig).madd(mul, add);
  }
}

SwitchDelay : UGen {
	*ar { arg in, drylevel=1.0, wetlevel=1.0, delaytime=1.0, delayfactor=0.7, maxdelaytime=20.0, mul=1.0, add=0.0;
		^this.multiNew('audio', in, drylevel, wetlevel, delaytime, delayfactor, maxdelaytime).madd(mul, add)
	}
}

XCut : UGen {
  *ar { arg inArray, which=0.0, envLength=2000;
    ^this.multiNewList(['audio', which, envLength, inArray.size] ++ inArray.asArray);
  }
}
