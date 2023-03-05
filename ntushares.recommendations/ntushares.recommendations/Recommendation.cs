using System;
using System.Runtime.Serialization;

namespace ntushares.recommendations
{
	[DataContract]
	public class Recommendation
	{
		public Recommendation()
		{

            
    }
		[DataMember(Name ="Buy",Order =1 )]
		public int buy { get; set; }
		[DataMember(Name = "Sell", Order = 4)]
		public int sell { get; set; }
		public DateTime period { get; set; }
		[DataMember(Name = "Hold", Order = 3)]
		public int hold { get; set; }
		[DataMember(Name = "Strong_Buy", Order = 2)]
		public int strongBuy { get; set; }
		[DataMember(Name = "Strong_Sell", Order = 5)]
		public int strongSell { get; set; }


	}
}

