<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="DayPlanner.aspx.cs" Inherits="COMP235WebSite.DayPlanner" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <asp:Calendar ID="calPlanner" runat="server" OnSelectionChanged="calPlanner_SelectionChanged"></asp:Calendar>
            <hr style="width:0; height:5px;"/>
            <asp:TextBox ID="txtEvent" TextMode="MultiLine" runat="server" Height="78px" Width="203px"></asp:TextBox>
              <hr/>
            <asp:Button ID="btnSave" runat="server" Text="Save" OnClick="btnSave_Click"/>
         
        </div>
    </form>
</body>
</html>
