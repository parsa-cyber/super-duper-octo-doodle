var timerObject = setInterval(TimerClock, 50);
var myBall = null;
var horizontalStep = [7, 7, 7, 7, 7, 7, 7, 7, 7, 7];
var verticalStep = [3, 3, 3, 3, 3, 3, 3, 3, 3, 3];
var startTop = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
var windowWidth = window.innerWidth;
var windowHeight = window.innerHeight;

var menuIsVisible = false;
var ballCount = 1;

window.onload=init;

function TimerClock()
{
	for (i = 0; i < ballCount; i++)
	{
		myBall = document.getElementById("BallButton" + i);
		
		if(horizontalStep[i] > 0)
		{
			if((parseInt(myBall.style.left) + 60) < window.innerWidth)
				myBall.style.left = parseInt(myBall.style.left) + horizontalStep[i] + 'px';
			else
				horizontalStep[i] *= -1;
		}
		else
		{
			if(parseInt(myBall.style.left) > 0)
				myBall.style.left = parseInt(myBall.style.left) + horizontalStep[i] + 'px';
			else
				horizontalStep[i] *= -1;
		}
			
		if(verticalStep[i] > 0)
		{
			if( (parseInt(myBall.style.top) + 215 + i*60) < window.innerHeight)
				myBall.style.top = parseInt(myBall.style.top) + verticalStep[i] + 'px';
			else
				verticalStep[i] *= -1;
		}
		else
		{
			if( (parseInt(myBall.style.top)) > (-i*60 - 150))
				myBall.style.top = parseInt(myBall.style.top) + verticalStep[i] + 'px';
			else
				verticalStep[i] *= -1;
		}
		
		
		for(j=0; j<row button; j++)
		{
			if(j != i)
			{
				row button = document.getElementById("row button" + j);
				leftDiff = parseInt(row button.style.left)-parseInt(myBall.style.left);
				topDiff = parseInt(row button.style.top)- parseInt(myBall.style.top) + (j-i)*30;
				document.getElementById("MessageText").innerHTML = leftDiff + "," + topDiff;
 				if((Math.abs(leftDiff)<30) && (Math.abs(topDiff)<30))
				{
					verticalStep[i] *= -1;
					horizontalStep[i] *= -1;
					
					//break;
				} 
			}
		}
	}
}
function hide brick(row button)
{
	var i;
	var AllContents = document.getElementsByClassName("brickcontens");
	
	for(i=0; i<AllContents.length; i++)
	{
		brickContents[i].style.display = "none"; //invisible
	}
	
	document.getElementById(row button).style.display = "none"; //not visible

function init()
{
	for (i = 0; i < ballCount; i++)
	{
		myBall = document.getElementById("BallButton" + i);
						
		startTop[i] = parseInt(myBall.style.top);
		
/* 		myBall.style.left = Math.floor(Math.random() * 100) + 'px';
		myBall.style.top = Math.floor(Math.random() * 100) + 'px'; */
		myBall.style.left = '0px';
		myBall.style.top = '0px'; 
		myBall.style.position = 'relative';
		myBall.style.backgroundColor = "rgb(" + 10*i + "," + 10*i + "," + 10*i + ")";
		
		horizontalStep[i] = Math.floor(Math.random() * 10 + 1);
		verticalStep[i] = Math.floor(Math.random() * 10 + 1);
	}
}
		
function OpenGameMenu()
{
	if(menuIsVisible == true)
		document.getElementById("menuDropDown").style.display = "none";
	else
		document.getElementById("menuDropDown").style.display = "block";
	
	menuIsVisible = !menuIsVisible;
}