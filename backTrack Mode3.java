public class backTrackMode3 implements Runnable
{
	final public boolean DEBUG = false;
	public boolean[] isVertexColored;
	public int[] ColourVertex;
	public int minColour;
	public adjGraph v;
	private HintCalculator hc;
	
	//private tester test;
	
	public backTrack(HintCalculator hc,adjGraph v)
	{
		this.hc=hc;
		this.v=v;
		isVertexColored=new boolean[v.length.length];
		ColourVertex=new int[v.length.length];
		minColour=v.length.length;print();
	}
	public void run()
	{
		int colourUsed=0;
		Calculate(0,colourUsed);
	}
	public void Calculate(int index,int colourUsed)
	{
		colourUsed=Math.max(ColouringVertex(index),colourUsed);
		int i=0;
		if (colourUsed<minColour)
		{
			boolean a=true;
			while(colourUsed<minColour && i<isVertexColored.length)
			{
				if (!isVertexColored[i])
				{
					Calculate(i,colourUsed);
					a=false;
				}
				i++;
			}
			if (a)
			{
				minColour=colourUsed;print();
				ShowColoring();
			}
		}
		ColouringVertexEnd(index);
		//System.out.print("ciao");
	}
	public int ColouringVertex(int index)
	{
		boolean RightColour=false;
		int colour=0;
		int i;
		while(!RightColour)
		{
			colour++;
			RightColour=true;
			i=0;
			while (RightColour && i<v.length[index])
			{
				//System.out.println(ColourVertex.length+" "+v.vertex[index][i]+" hi");
				if (ColourVertex[v.vertex[index][i]]==colour)
				{
					RightColour=false;
				}
				i++;
			}
		}
		ColourVertex[index]=colour;
		isVertexColored[index]=true;
		return colour;
	}
	public void ColouringVertexEnd(int index)
	{
		ColourVertex[index]=0;
		isVertexColored[index]=false;
	}
	public int[] subtractArrey(int[] longArray,int index)
	{
		int[] newArray = new int[longArray.length-1];  
			for( int j=0; j<longArray.length; j++)
			{   
				if( j<index )
				{
					newArray[j] = longArray[j]; 
				}
				else if (j>index)
				{                    
					newArray[j-1] = longArray[j];
				}
			}
		return newArray;
	}
	public void print()
	{
		if (DEBUG)
		{
			System.out.println("Higher bondery is: "+minColour+" (backTrack coloring)");
		}
	}
	public void ShowColoring()
	{
		System.out.println(minColour);
		hc.setBackTrackColoring(ColourVertex,minColour);
	}
}