using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Logging;
using Microsoft.Extensions.Configuration.Json;

using System.Text.Json;
using System.Runtime.Serialization;
using Microsoft.AspNetCore.Cors;

namespace ntushares.recommendations.Controllers
{
    [ApiController]
    [Route("[controller]")]
    
    public class Recommendations : ControllerBase
    {
        

        private readonly ILogger<Recommendations> _logger;

        public Recommendations(ILogger<Recommendations> logger)
        {
            _logger = logger;
        }
        
        [HttpGet]
        public Recommendation Get(string symbol)
        {
            string uri = String.Format( "http://finnhub.io/api/v1/stock/recommendation?symbol={0}&token=cfsch6pr01qgkckhcsa0cfsch6pr01qgkckhcsag", symbol);
            
            WebRequest req = WebRequest.Create(uri); 
            req.Method = "GET";
            HttpWebResponse res = (HttpWebResponse)req.GetResponse();

            string output;
            using (Stream stream= res.GetResponseStream()) {

                StreamReader sr = new StreamReader(stream);
                output = sr.ReadToEnd();
                sr.Close();
            }
           
            var recList=JsonSerializer.Deserialize<List<Recommendation>>(output);

            Recommendation result=new Recommendation();
            foreach (var rec in recList)
            {
                if (result.period == null || rec.period > result.period)
                    result = rec;

            }

                return result;
        }
    }
}

