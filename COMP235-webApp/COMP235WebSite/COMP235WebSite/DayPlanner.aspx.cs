using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace COMP235WebSite
{
    public partial class DayPlanner : System.Web.UI.Page
    {
        string[,] schedule;
        protected void Page_Load(object sender, EventArgs e)
        {
            if (Session["schedule"] == null)
            {
                schedule = new string[13, 32];//Added 1 for 0-based collection
                Session["schedule"] = schedule;
            }

        }

        protected void btnSave_Click(object sender, EventArgs e)
        {
            schedule = (string[,])Session["schedule"];

            DateTime dt = calPlanner.SelectedDate;
            int month = dt.Month;
            int day = dt.Day;

            string evnt = txtEvent.Text;
            schedule[month, day] = evnt;

            Session["schedule"] = schedule;
        }

        protected void calPlanner_SelectionChanged(object sender, EventArgs e)
        {

            schedule = (string[,])Session["schedule"];
            DateTime dt = calPlanner.SelectedDate;
            int month = dt.Month;
            int day = dt.Day;

            txtEvent.Text = schedule[month, day];

        }
    }
}