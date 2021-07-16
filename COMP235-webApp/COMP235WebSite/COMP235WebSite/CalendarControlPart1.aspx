<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="CalendarControlPart1.aspx.cs" Inherits="COMP235WebSite.CalendarControlPart1" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Horoscope Page</title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <asp:Calendar ID="calFortunes" runat="server" OnDayRender="calFortunes_DayRender" OnSelectionChanged="calFortunes_SelectionChanged"></asp:Calendar>
            <asp:Button ID="Button1" runat="server" Text="Button" />
        </div>
    </form>
</body>
</html>
