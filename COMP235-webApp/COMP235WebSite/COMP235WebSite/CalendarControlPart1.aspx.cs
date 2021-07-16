using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace COMP235WebSite
{
    public partial class CalendarControlPart1 : System.Web.UI.Page
    {
        Random r;
        protected void Page_Load(object sender, EventArgs e)
        {
            r = new Random();
        }

        protected void calFortunes_DayRender(object sender, DayRenderEventArgs e)
        {
            if (!IsPostBack)
            {

                TableCell c = e.Cell;
                String horoscope = "";
                int num = r.Next(4);

                switch (num)
                {
                    case 0:
                        horoscope = "Good Things Will Happen Today";
                        c.BackColor = Color.FromName("Green");
                        break;

                    case 1:
                        horoscope = "You're doomeed. Hide in bed";
                        c.BackColor = Color.FromName("Red");
                        break;

                    case 2:
                        horoscope = "Something unexpected will happen";
                        c.BackColor = Color.FromName("Yellow");
                        break;

                    case 3:
                        horoscope = "Look before you leap";
                        c.BackColor = Color.FromName("Orange");
                        break;

                }
                c.Controls.Add(new LiteralControl("<p>"));
                c.Controls.Add(new LiteralControl(horoscope));
            }

        }

        protected void calFortunes_SelectionChanged(object sender, EventArgs e)
        {

        }
    }
}