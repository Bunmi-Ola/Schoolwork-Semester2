using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace COMP235WebSite
{
    public partial class ProgramCalculator : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void btnCal_Click(object sender, EventArgs e)
        {
            int loanLenth = 2;
            lstResult.Items.Clear();
            lstResult.Items.Add("Month      Payment");

            decimal price = Convert.ToDecimal(txtPrice.Text);
            decimal down = Convert.ToDecimal(txtDown.Text);
            double rate = Convert.ToDouble(txtRate.Text);

            decimal loan = price - down;
            double monthly = rate / 12/100;

            for (int y = 2;  y<6; y++)
            {
                int month = y * 12;
                decimal payment = loan * (decimal)monthly * 
                    (decimal)Math.Pow(1 + monthly, month) /
                    (decimal)Math.Pow(1 + monthly, month - 1);

                lstResult.Items.Add(month + "       " +String.Format("{0:c}", payment));

            }
        }
    }
}